package co.com.sisevid.api.controller.implementationSolid;

import co.com.sisevid.api.controller.docs.UserRolControllerDoc;
import co.com.sisevid.api.dto.UserRolDTO;
import co.com.sisevid.api.dto.security.ApiResponseDTO;
import co.com.sisevid.api.entities.UserRol;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/rolsCrud")
@CrossOrigin(origins = "*")
public class UserRolControllerSolid implements UserRolControllerDoc {

    @PostMapping()
    public ResponseEntity<ApiResponseDTO<UserRolDTO>> save(UserRol userRol) {
        return null;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponseDTO<Object>> delete(Long id) {
        return null;
    }

    @PutMapping()
    public ResponseEntity<ApiResponseDTO<UserRolDTO>> update(UserRol userRol) throws EntityNotFoundException {
        return null;
    }

    @GetMapping(path = "/findRols", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<ApiResponseDTO<List<UserRolDTO>>> findEvidences(Long id, String title, String description, String type, String typeFile, String evidenceCreationDate, String evidenceRegisterDate, String authors, String observation, String userCreate, String creationDate) throws EntityNotFoundException {
        return null;
    }
}
