package co.com.sisevid.api.controller.implementationSolid;

import co.com.sisevid.api.controller.docs.UserRolControllerDoc;
import co.com.sisevid.api.dto.UserRolDTO;
import co.com.sisevid.api.dto.security.ApiResponseDTO;
import co.com.sisevid.api.entities.Rol;
import co.com.sisevid.api.entities.User;
import co.com.sisevid.api.entities.UserRol;
import co.com.sisevid.api.services.implementation.UserRolCrud;
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
@RequestMapping("/rolsCrud")
@CrossOrigin(origins = "*")
public class UserRolControllerSolid implements UserRolControllerDoc {
    private final ObjectMapper objectMapper;
    private final UserRolCrud userRolCrud;

    public UserRolControllerSolid(ObjectMapper objectMapper, UserRolCrud userRolCrud) {
        this.objectMapper = objectMapper;
        this.userRolCrud = userRolCrud;
    }

    @PostMapping()
    public ResponseEntity<ApiResponseDTO<UserRolDTO>> save(UserRol userRol) {
        final UserRol userRolSaved = userRolCrud.save(userRol);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponseDTO.<UserRolDTO>builder()
                        .code(HttpStatus.CREATED.value())
                        .message("Client saved successfully")
                        .data(objectMapper.convertValue(userRolSaved, UserRolDTO.class))
                        .build()
                );
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponseDTO<Object>> delete(Long id) {
        userRolCrud.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseDTO.builder()
                        .code(HttpStatus.OK.value())
                        .message("Rol deleted successfully")
                        .build()
                );
    }

    @PutMapping()
    public ResponseEntity<ApiResponseDTO<UserRolDTO>> update(UserRol userRol) throws EntityNotFoundException {
        return null;
    }

    @GetMapping(path = "/findRols", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<ApiResponseDTO<List<UserRolDTO>>> findEvidences(
            @RequestParam(name = "id", required = false) final Long id,
            @RequestParam(name = "user", required = false) final User user,
            @RequestParam(name = "rol", required = false) final Rol rol
    ) throws EntityNotFoundException {
        List<UserRol> userRol = userRolCrud.findByFilters(id, user, rol);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.<List<UserRolDTO>>builder()
                .code(HttpStatus.OK.value())
                .message("Client list retrieved successfully")
                .data(userRol.stream().map(this::convertModelToDto).collect(Collectors.toList())).build());
    }

    private UserRolDTO convertModelToDto(UserRol userRol) {
        return objectMapper.convertValue(userRol, UserRolDTO.class);
    }
}
