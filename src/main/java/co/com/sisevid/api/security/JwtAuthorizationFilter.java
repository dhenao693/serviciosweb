package co.com.sisevid.api.security;

import co.com.sisevid.api.dto.UserDto;
import co.com.sisevid.api.dto.security.ApiResponseDTO;
import co.com.sisevid.api.dto.security.CompanyDTO;
import co.com.sisevid.api.dto.security.UserRequestResponse;
import co.com.sisevid.api.exceptions.BusinessRuleException;
import co.com.sisevid.api.utils.constants.Constants;
import co.com.sisevid.api.utils.constants.PermissionsConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import static co.com.sisevid.api.utils.constants.Constants.AUDIENCE_SERVICE;
import static co.com.sisevid.api.utils.constants.Constants.BEARER;

@Slf4j
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    public static final String SECRET = "poli_jic_2022";
    private final Environment environment;
    private final ObjectMapper objectMapper;

    public JwtAuthorizationFilter(@NotNull final Environment environment,
                                  ObjectMapper objectMapper) {
        this.environment = environment;
        this.objectMapper = objectMapper;
    }

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        log.info("Starting authentication process...");

        if (!existJwtToken(request)) {
            log.trace("Token does not exist.");
            denyRequest(response, HttpStatus.UNAUTHORIZED, "Token does not exist.");
            return;
        }

        log.info("Getting token prefix.");
        String tokenPrefix = BEARER;
        log.info("Token prefix: " + tokenPrefix);

        log.info("Getting JWT token from request.");
        String jwtToken = request.getHeader(HttpHeaders.AUTHORIZATION)
                .substring(tokenPrefix.length());
        log.trace("JWT token: {}", jwtToken);

        UserRequestResponse userRequestResponse;

        try {
            log.trace("Getting claims from JWT");
            Claims claims = getClaims(jwtToken);
            log.trace("Claims obtained successfully");

            userRequestResponse = validateUserInfoAndRequest(request, claims);

            if (!isValidModulesAndUser(claims, userRequestResponse.getUser())) {
                denyRequest(response, HttpStatus.UNAUTHORIZED, "Insufficient permissions.");
                return;
            }

            log.trace("Token is valid.");
            log.trace("Authenticate User");
            UsernamePasswordAuthenticationToken auth = authenticateUser(claims,
                    userRequestResponse.getUser());
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(auth);
            log.trace("Authenticated user successfully");
        } catch (BusinessRuleException e) {
            log.error(e.getMessage(), e);
            denyRequest(response, HttpStatus.BAD_REQUEST, e.getMessage());
            return;
        } catch (JwtException e) {
            log.error(e.getMessage(), e);
            denyRequest(response, HttpStatus.UNAUTHORIZED, e.getMessage());
            return;
        }

        filterChain.doFilter(userRequestResponse.getRequest(), response);
        log.info("Authentication process ended successfully.");
    }

    private boolean existJwtToken(@NotNull final HttpServletRequest request) {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        log.trace("Getting token prefix.");
        String tokenPrefix = BEARER;
        log.trace("Token prefix: " + tokenPrefix);
        return !(authHeader == null || !authHeader.startsWith(tokenPrefix));
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token).getBody();
    }

    private UserRequestResponse validateUserInfoAndRequest(HttpServletRequest request,
                                                           Claims claims) throws IOException, BusinessRuleException {
        UserRequestResponse userRequestResponse = UserRequestResponse.builder()
                .user(UserDto.builder().id(Constants.USER_SERVICE).build()).request(request).build();

        if (!claims.getAudience().equals(Constants.AUDIENCE_SERVICE)) {
            userRequestResponse.getUser().setId(Long.valueOf(null));
            Map<String, Object> tokenUser = claims.get("user", Map.class);

            if (tokenUser != null && tokenUser.get("id") != null) {
                log.trace("Getting userDTO from token");
                userRequestResponse.setUser(getUserDTOFromToken(tokenUser));
                log.trace("userDTO obtained from token successfully: {}",
                        userRequestResponse.getUser());
            }
        } else {
            log.trace("Identifying the type of request...");

            if (request.getContentType() != null) {

                if (request.getContentType().contains(MediaType.MULTIPART_FORM_DATA_VALUE)) {
                    log.trace("The type of request is: {}", MediaType.MULTIPART_FORM_DATA_VALUE);

                    JsonNode jsonData = getJsonNode(request);

                    log.trace("Getting userDTO from jsonData");
                    userRequestResponse.setUser(getUserFromJsonNode(jsonData));
                    log.trace("userDTO obtained from jsonData successfully: {}",
                            userRequestResponse.getUser());
                } else if (request.getContentType().contains(MediaType.APPLICATION_JSON_VALUE)) {
                    log.trace("The type of request is: {}", MediaType.APPLICATION_JSON_VALUE);
                    setRequestUser(request, userRequestResponse);
                } else {
                    throw new BusinessRuleException("Unsupported Content-Type");
                }
            } else {
                if (HttpMethod.GET.name().equals(request.getMethod()) ||
                        HttpMethod.DELETE.name().equals(request.getMethod())) {
                    setRequestUser(request, userRequestResponse);
                } else {
                    throw new BusinessRuleException("Content-Type must be specified.");
                }
            }

        }

        return userRequestResponse;
    }

    private void setRequestUser(HttpServletRequest request, UserRequestResponse userRequestResponse)
            throws IOException {

        CachedBodyHttpServletRequest cachedBodyHttpServletRequest =
                new CachedBodyHttpServletRequest(request);

        userRequestResponse.setRequest(cachedBodyHttpServletRequest);

        String body = getBodyFromInputStream(cachedBodyHttpServletRequest);
        log.trace("cachedBodyHttpServletRequest: {}", body);

        JsonNode jsonNode = objectMapper.readTree(body);
        log.trace("jsonNode: {}", jsonNode);

        log.trace("Getting userDTO from Body");
        userRequestResponse.setUser(getUserFromJsonNode(jsonNode));
        log.trace("userDTO obtained from Body successfully: {}",
                userRequestResponse.getUser());

    }

    private JsonNode getJsonNode(HttpServletRequest request)
            throws JsonProcessingException, BusinessRuleException {
        log.trace("Getting jsonData from Body");

        if (request.getParameter(Constants.JSON_DATA) == null) {
            throw new BusinessRuleException("Required request part 'jsonData' is not present.");
        }

        JsonNode jsonData = objectMapper.readTree(request.getParameter(Constants.JSON_DATA));
        log.trace("jsonData obtained successfully: {}", jsonData);
        return jsonData;
    }

    private static UserDto getUserDTOFromToken(Map<String, Object> tokenUser) {
        log.trace("Getting UserDTO from token {}", tokenUser);
        UserDto userDTO = UserDto.builder()
                .id(Long.valueOf(tokenUser.get("id").toString())).build();
        List<CompanyDTO> companyList = getCompanyListFromTokenCompanies(
                (List<Map<String, String>>) tokenUser.get("companies"));

        try {
            userDTO.setPassword((tokenUser.get("password").toString()));
            userDTO.setUser(tokenUser.get("user").toString());
            userDTO.setUserCreate(tokenUser.get("userCreate").toString());
            userDTO.setDateCreate(tokenUser.get("dateCreate").toString());
        } catch (NullPointerException exception) {
            log.error("The user information is not complete");
        }

        return userDTO;
    }

    private static List<CompanyDTO> getCompanyListFromTokenCompanies(
            List<Map<String, String>> tokenCompanies) {
        List<CompanyDTO> resultSet = new ArrayList<>();

        try {
            tokenCompanies.forEach((Map<String, String> setCompany) -> {
                CompanyDTO company = CompanyDTO.builder()
                        .id(Long.valueOf(String.valueOf(setCompany.get("id"))))
                        .name(setCompany.get("name"))
                        .timezone(setCompany.get("timezone"))
                        .build();
                resultSet.add(company);
            });
        } catch (NullPointerException exception) {
            log.error("The user's company information is not complete");
        }

        return resultSet;
    }

    private UserDto getUserFromJsonNode(JsonNode jsonNode) throws JsonProcessingException {
        UserDto userDTO = UserDto.builder().id(Constants.USER_SERVICE).build();

        if (jsonNode.get(Constants.USER_NODE) != null) {
            userDTO = objectMapper.readValue(jsonNode.get(Constants.USER_NODE).toString(), UserDto.class);
            log.trace("UserDTO: {}", userDTO);
        }

        return userDTO;
    }

    private String getBodyFromInputStream(HttpServletRequest request) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader;

        try (InputStream inputStream = request.getInputStream()) {
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
        }

        return stringBuilder.toString();
    }

    private boolean isValidModulesAndUser(Claims claims, UserDto userDTO) {
        if (/*userDTO.getId() == null || */!isValidModules(claims)) {
            log.error("Invalid user or modules");
            return false;
        }

        return isValidAudience(claims);
    }

    private boolean isValidModules(Claims claims) {
        if (!claims.getAudience().equals(Constants.AUDIENCE_SERVICE)) {
            log.trace("Getting system modules.");
            String tokenModValidValue = environment.getRequiredProperty("jwt.token.mod");
            List<String> listMods = Arrays.asList(tokenModValidValue.split(","));
            log.trace("Modules obtained successfully: {}", tokenModValidValue);

            log.trace("Getting token modules.");
            List<String> tokenMods = claims.get("mod", ArrayList.class);
            log.trace("Token modules obtained successfully: {}", tokenMods);

            log.trace("Validating modules");

            if (tokenMods == null || tokenMods.stream().noneMatch(listMods::contains)) {
                log.trace("Modules no valid ");
                return false;
            }

            log.trace("Valid modules");
        }

        return true;
    }

    private boolean isValidAudience(Claims claims) {
        log.trace("Getting system audiences.");
        String tokenAudValues = AUDIENCE_SERVICE;
        List<String> tokenAudValidValues = Arrays.asList(tokenAudValues.split(","));
        log.trace("Audiences obtained successfully: {}", tokenAudValues);

        log.trace("Getting token audience.");
        String tokenAud = claims.getAudience();
        log.trace("Token audience obtained successfully: {}", tokenAud);

        log.trace("Validating audience");

        if (tokenAud == null || !tokenAudValidValues.contains(tokenAud)) {
            log.error("Audience no valid");
            return false;
        }

        log.trace("Valid audience");
        return true;
    }

    public UsernamePasswordAuthenticationToken authenticateUser(Claims claims, UserDto userDTO) {
        Set<SimpleGrantedAuthority> grantedValues = getGrantedValues(claims);
        return new UsernamePasswordAuthenticationToken(userDTO, "", grantedValues);
    }

    private static Set<SimpleGrantedAuthority> getGrantedValues(Claims claims) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + PermissionsConstants.SERVICE));

        if (!claims.getAudience().equals(Constants.AUDIENCE_SERVICE)) {
            authorities.clear();
            log.trace("Getting token permissions.");
            List<String> scopes = claims.get("per", ArrayList.class);
            log.trace("Token permissions obtained successfully: " + scopes);

            if (scopes != null) {
                scopes.forEach(x -> authorities.add(
                        new SimpleGrantedAuthority("ROLE_" + x.toUpperCase(Locale.getDefault()))));
            }
        }

        return authorities;
    }

    private void denyRequest(@NotNull final HttpServletResponse response, HttpStatus status,
                             String... errorMessages) {
        try (PrintWriter writer = response.getWriter()) {
            ApiResponseDTO<Object> apiResponse = new ApiResponseDTO<>();
            apiResponse.setMessage(status.getReasonPhrase());
            apiResponse.setCode(status.value());
            apiResponse.setError(List.of(errorMessages));
            String dataResponse = objectMapper.writeValueAsString(apiResponse);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            writer.write(dataResponse);
            writer.flush();
        } catch (IOException e) {
            log.trace("Error while writing response to deny request.");
            log.error(e.getMessage(), e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
