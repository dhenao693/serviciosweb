package co.com.sisevid.api.controller;

import co.com.sisevid.api.dto.EvidenceDetailsDTO;
import co.com.sisevid.api.services.evidencedetails.implementation.ConsultAllEvidenceDetails;
import co.com.sisevid.api.services.evidencedetails.implementation.ConsultEvidenceDetails;
import co.com.sisevid.api.services.evidence.implementation.DeleteEvidence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evidenceDetails")
public class EvidenceDetailsController {
    @Autowired
    private ConsultEvidenceDetails consultEvidenceDetails;

    @Autowired
    private ConsultAllEvidenceDetails consultAllEvidenceDetails;

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

    @GetMapping(path = "/consultAllEvidencesDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EvidenceDetailsDTO>> seeEvidencesDetails() {
        try {
            return ResponseEntity.ok(consultAllEvidenceDetails.consultAllEvidenceDetails());
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
