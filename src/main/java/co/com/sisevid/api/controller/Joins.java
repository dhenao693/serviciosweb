package co.com.sisevid.api.controller;

import co.com.sisevid.api.dto.EvidenceDTO;
import co.com.sisevid.api.dto.RolDTO;
import co.com.sisevid.api.dto.UserWithRolsDTO;
import co.com.sisevid.api.services.evidence.implementation.ConsultEvidences;
import co.com.sisevid.api.services.joins.implementation.UserWithRols;
import co.com.sisevid.api.services.rols.implementation.ConsultRol;
import co.com.sisevid.api.services.rols.implementation.ConsultRols;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/joins")
public class Joins {
    @Autowired
    private UserWithRols userWithRols;

    @GetMapping(path = "/consultUserWithRols", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserWithRolsDTO> verEmpleados(@RequestParam("user") String user) {
        try {
            return ResponseEntity.ok(userWithRols.consultUserWithRols(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
