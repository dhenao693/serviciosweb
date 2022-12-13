package co.com.sisevid.api.controller;

import co.com.sisevid.api.dto.UserDto;
import co.com.sisevid.api.services.user.CreateUserService;
import co.com.sisevid.api.services.user.implementation.ConsultUser;
import co.com.sisevid.api.services.user.implementation.ConsultUsers;
import co.com.sisevid.api.services.user.implementation.CreateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private ConsultUser consultUser;

    @Autowired
    private ConsultUsers consultUsers;

    @Autowired
    private CreateUserService createUser;

    @GetMapping(path = "/consultUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> seeUsers() {
        try {
            return ResponseEntity.ok(consultUsers.consultUsers());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/consultUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> verEmpleados(@RequestParam("user") String user) {
        try {
            return ResponseEntity.ok(consultUser.consultUser(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(path = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> guardarEmpleado(@RequestBody UserDto user) {
        try {
            return ResponseEntity.ok(createUser.createUser(user));
        } catch (Exception e) {
            return null;
        }
    }
}
