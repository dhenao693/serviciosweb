package co.com.sisevid.api.controller.implementations;

import co.com.sisevid.api.dto.UserRolDTO;
import co.com.sisevid.api.services.userrol.implementation.ConsultUserRol;
import co.com.sisevid.api.services.userrol.implementation.ConsultUserRolByUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usersRol")
public class UserRolController {
    @Autowired
    private ConsultUserRol consultUsuarioRol;

    @Autowired
    private ConsultUserRolByUser consultUserRolByUser;


    @GetMapping(path = "/consultUserRols", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserRolDTO>> seeAllUserRol() {
        try {
            return ResponseEntity.ok(consultUsuarioRol.consultUsersRols());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/consultUserRolsByUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserRolDTO>> seeAllUserRolByUser(@RequestParam("id") Long id) {
        try {
            return ResponseEntity.ok(consultUserRolByUser.consultUserRolsByUser(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
