package co.com.sisevid.api.controller.implementationSolid;

import co.com.sisevid.api.controller.docs.UserControllerDoc;
import co.com.sisevid.api.dto.UserDto;
import co.com.sisevid.api.dto.security.ApiResponseDTO;
import co.com.sisevid.api.entities.Evidence;
import co.com.sisevid.api.entities.User;
import co.com.sisevid.api.services.implementation.UserCrud;
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
@RequestMapping("/userCrud")
@CrossOrigin(origins = "*")
public class UserControllerSolid implements UserControllerDoc {
    private final ObjectMapper objectMapper;
    private final UserCrud userCrud;

    public UserControllerSolid(ObjectMapper objectMapper, UserCrud userCrud) {
        this.objectMapper = objectMapper;
        this.userCrud = userCrud;
    }


    @PostMapping()
    public ResponseEntity<ApiResponseDTO<UserDto>> save(Evidence evidence) {
        return null;
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponseDTO<Object>> delete(Long id) {
        return null;
    }

    @PutMapping()
    public ResponseEntity<ApiResponseDTO<UserDto>> update(Evidence client) throws EntityNotFoundException {
        return null;
    }

    @GetMapping(path = "/findUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<ApiResponseDTO<List<UserDto>>> findUsers(@RequestParam(name = "id", required = false) final Long id,
                                                                   @RequestParam(name = "idUserInfo", required = false) final String idUserInfo,
                                                                   @RequestParam(name = "user", required = false) final String user,
                                                                   @RequestParam(name = "password", required = false) final String password,
                                                                   @RequestParam(name = "userCreate", required = false) final String userCreate,
                                                                   @RequestParam(name = "dateCreate", required = false) final String dateCreate)
            throws EntityNotFoundException {
        List<User> userList = userCrud.findByFilters(id, idUserInfo, user, password, userCreate, dateCreate);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponseDTO.<List<UserDto>>builder()
                        .code(HttpStatus.OK.value())
                        .message("Client list retrieved successfully")
                        .data(userList.stream().map(this::convertModelToDto).collect(Collectors.toList()))
                        .build()
                );
    }

    private UserDto convertModelToDto(User user) {
        return objectMapper.convertValue(user, UserDto.class);
    }

}
