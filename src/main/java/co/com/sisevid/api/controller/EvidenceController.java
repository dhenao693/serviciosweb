package co.com.sisevid.api.controller;

import co.com.sisevid.api.dto.EvidenceDTO;
import co.com.sisevid.api.dto.RolDTO;
import co.com.sisevid.api.services.evidence.implementation.ConsultEvidences;
import co.com.sisevid.api.services.rols.implementation.ConsultRol;
import co.com.sisevid.api.services.rols.implementation.ConsultRols;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evidences")
public class EvidenceController {
    @Autowired
    private ConsultEvidences consultEvidences;

    @GetMapping(path = "/consultEvidences", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EvidenceDTO>> seeUsers() {
        try {
            return ResponseEntity.ok(consultEvidences.consultEvidences());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
