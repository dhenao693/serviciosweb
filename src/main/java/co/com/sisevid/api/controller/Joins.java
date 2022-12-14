package co.com.sisevid.api.controller;

import co.com.sisevid.api.dto.EvidenceDTO;
import co.com.sisevid.api.dto.EvidenceWithDetailsDTO;
import co.com.sisevid.api.dto.RolDTO;
import co.com.sisevid.api.dto.UserWithRolsDTO;
import co.com.sisevid.api.services.evidence.implementation.ConsultEvidences;
import co.com.sisevid.api.services.joins.implementation.ConsultEvidenceWithDetails;
import co.com.sisevid.api.services.joins.implementation.CreateEvidenceWithDetails;
import co.com.sisevid.api.services.joins.implementation.DeleteEvidenceWithDetails;
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

    @Autowired
    private DeleteEvidenceWithDetails deleteEvidenceWithDetails;

    @Autowired
    private ConsultEvidenceWithDetails consultEvidenceWithDetails;

    @Autowired
    private CreateEvidenceWithDetails createEvidenceWithDetails;

    @GetMapping(path = "/consultUserWithRols", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserWithRolsDTO> verEmpleados(@RequestParam("user") String user) {
        try {
            return ResponseEntity.ok(userWithRols.consultUserWithRols(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(path = "/deleteEvidenceWithDetails/{idEvidencia}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> verEmpleados(@PathVariable Long idEvidencia) {
        try {
            deleteEvidenceWithDetails.deleteEvidenceWith(idEvidencia);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/consultEvidenceWithDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EvidenceWithDetailsDTO>> verEmpleados() {
        try {
            return ResponseEntity.ok(consultEvidenceWithDetails.consultEvidenceWithDetails());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(path = "/createEvidenceWithDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> verEmpleados(@RequestBody EvidenceWithDetailsDTO evidenceWithDetailsDTO) {
        try {
            createEvidenceWithDetails.createEvidenceWithDetails(evidenceWithDetailsDTO);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
