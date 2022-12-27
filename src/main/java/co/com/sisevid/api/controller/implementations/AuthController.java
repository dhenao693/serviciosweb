package co.com.sisevid.api.controller.implementations;

import co.com.sisevid.api.controller.AuthControllerDocs;
import co.com.sisevid.api.dto.security.ApiResponseDTO;
import co.com.sisevid.api.dto.security.JwtDto;
import co.com.sisevid.api.utils.ClientAuthentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController implements AuthControllerDocs {

    @GetMapping()
    public ResponseEntity<ApiResponseDTO<JwtDto>> getAuthorization() {
        String token = ClientAuthentication.generateToken();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponseDTO.<JwtDto>builder()
                        .code(HttpStatus.CREATED.value())
                        .message("Token created successfully")
                        .data(new JwtDto(token))
                        .build());
    }
}
