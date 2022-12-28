package co.com.sisevid.api.controller.implementationSolid;

import co.com.sisevid.api.controller.docs.UserInfoControllerDoc;
import co.com.sisevid.api.dto.UserInfoContactDTO;
import co.com.sisevid.api.dto.security.ApiResponseDTO;
import co.com.sisevid.api.entities.UserInfoContact;
import co.com.sisevid.api.services.implementation.UserInfoCrud;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/userInfoCrud")
@CrossOrigin(origins = "*")
public class UserInfoControllerSolid implements UserInfoControllerDoc {
    private final ObjectMapper objectMapper;
    private final UserInfoCrud userInfoCrud;

    public UserInfoControllerSolid(ObjectMapper objectMapper, UserInfoCrud userInfoCrud) {
        this.objectMapper = objectMapper;
        this.userInfoCrud = userInfoCrud;
    }

    @PostMapping()
    public ResponseEntity<ApiResponseDTO<UserInfoContactDTO>> save(UserInfoContact userInfoContact) {
        final UserInfoContact userinfoSaved = userInfoCrud.save(userInfoContact);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponseDTO.<UserInfoContactDTO>builder()
                        .code(HttpStatus.CREATED.value())
                        .message("Client saved successfully")
                        .data(objectMapper.convertValue(userinfoSaved, UserInfoContactDTO.class))
                        .build()
                );
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponseDTO<Object>> delete(Long id) {
        userInfoCrud.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseDTO.builder()
                        .code(HttpStatus.OK.value())
                        .message("User info deleted successfully")
                        .build()
                );
    }

    @PutMapping()
    public ResponseEntity<ApiResponseDTO<UserInfoContactDTO>> update(UserInfoContact client) throws EntityNotFoundException {
        return null;
    }

    @GetMapping(path = "/findUserInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<ApiResponseDTO<List<UserInfoContactDTO>>> findUsers(
            @RequestParam(name = "id", required = false) final Long id,
            @RequestParam(name = "documentType", required = false) final String documentType,
            @RequestParam(name = "documentNumber", required = false) final String documentNumber,
            @RequestParam(name = "name", required = false) final String name,
            @RequestParam(name = "lastName", required = false) final String lastName,
            @RequestParam(name = "phone", required = false) final String phone,
            @RequestParam(name = "email", required = false) final String email,
            @RequestParam(name = "userCreate", required = false) final String userCreate,
            @RequestParam(name = "dateCreate", required = false) final String dateCreate)
            throws EntityNotFoundException {
        List<UserInfoContact> userInfoContacts = userInfoCrud.findByFilters(id, documentType, documentNumber, name, lastName, phone, email, userCreate, dateCreate);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.<List<UserInfoContactDTO>>builder()
                .code(HttpStatus.OK.value())
                .message("Client list retrieved successfully")
                .data(userInfoContacts.stream().map(this::convertModelToDto).collect(Collectors.toList())).build());
    }

    private UserInfoContactDTO convertModelToDto(UserInfoContact userInfoContact) {
        return objectMapper.convertValue(userInfoContact, UserInfoContactDTO.class);
    }
}
