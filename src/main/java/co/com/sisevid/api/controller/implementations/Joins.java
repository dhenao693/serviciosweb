package co.com.sisevid.api.controller.implementations;

import co.com.sisevid.api.dto.EvidenceWithDetailsDTO;
import co.com.sisevid.api.dto.UserWithRolsDTO;
import co.com.sisevid.api.services.joins.implementation.ConsultEvidenceWithDetails;
import co.com.sisevid.api.services.joins.implementation.CreateEvidenceWithDetails;
import co.com.sisevid.api.services.joins.implementation.DeleteEvidenceWithDetails;
import co.com.sisevid.api.services.joins.implementation.UserWithRols;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<UserWithRolsDTO> seeUserWithRols(@RequestParam("user") String user) {
        try {
            return ResponseEntity.ok(userWithRols.consultUserWithRols(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(path = "/deleteEvidenceWithDetails/{idEvidencia}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteEvidenceWithDetails(@PathVariable Long idEvidencia) {
        try {
            deleteEvidenceWithDetails.deleteEvidenceWith(idEvidencia);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "/consultEvidenceWithDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EvidenceWithDetailsDTO>> seeEvidenceWithDetails() {
        try {
            return ResponseEntity.ok(consultEvidenceWithDetails.consultEvidenceWithDetails());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(path = "/createEvidenceWithDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createEvidenceWithDetails(@RequestBody EvidenceWithDetailsDTO evidenceWithDetailsDTO) {
        try {
            createEvidenceWithDetails.createEvidenceWithDetails(evidenceWithDetailsDTO);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
