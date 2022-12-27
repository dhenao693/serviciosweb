package co.com.sisevid.api.controller;

import co.com.sisevid.api.dto.RolDTO;
import co.com.sisevid.api.services.rols.implementation.ConsultRol;
import co.com.sisevid.api.services.rols.implementation.ConsultRolById;
import co.com.sisevid.api.services.rols.implementation.ConsultRols;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rols")

public class RolController {
    @Autowired
    private ConsultRols consultRols;

    @Autowired
    private ConsultRol consultRol;

    @Autowired
    private ConsultRolById consultRolById;

    @GetMapping(path = "/consultRols", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RolDTO>> seeRols() {
        try {
            return ResponseEntity.ok(consultRols.consultRols());
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(path = "/consultRol", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RolDTO> seeRol(@RequestParam("rol") String rol) {
        try {
            return ResponseEntity.ok(consultRol.consultRol(rol));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/consultRolById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RolDTO> seeRolsById(@RequestParam("id") Long id) {
        try {
            return ResponseEntity.ok(consultRolById.consultRolsById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
