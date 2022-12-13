package co.com.sisevid.api.controller;

import co.com.sisevid.api.dto.EvidenceDTO;
import co.com.sisevid.api.dto.EvidenceDetailsDTO;
import co.com.sisevid.api.dto.RolDTO;
import co.com.sisevid.api.services.evidence.implementation.ConsultEvidenceDetails;
import co.com.sisevid.api.services.evidence.implementation.ConsultEvidences;
import co.com.sisevid.api.services.evidence.implementation.DeleteEvidence;
import co.com.sisevid.api.services.rols.implementation.ConsultRol;
import co.com.sisevid.api.services.rols.implementation.ConsultRols;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/evidenceDetails")
public class EvidenceDetailsController {
    @Autowired
    private ConsultEvidenceDetails consultEvidenceDetails;

    @Autowired
    private DeleteEvidence deleteEvidence;

    @GetMapping(path = "/consultEvidencesDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EvidenceDetailsDTO>> seeEvidencesDetails(@RequestParam("evidenceId") Long evidenceId) {
        try {
            return ResponseEntity.ok(consultEvidenceDetails.consultEvidenceDetails(evidenceId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(path = "/deteleEvidence/{idEvidencia}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> seeUsers(@PathVariable Long idEvidencia) {
        try {
            //deleteEvidence.deleteById(idEvidencia);
            return ResponseEntity.badRequest().build();
            //return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
