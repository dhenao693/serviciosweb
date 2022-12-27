package co.com.sisevid.api.controller;

import co.com.sisevid.api.dto.EvidenceDTO;
import co.com.sisevid.api.services.evidence.implementation.ConsultEvidences;
import co.com.sisevid.api.services.evidence.implementation.DeleteEvidence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/evidences")
public class EvidenceController {
    @Autowired
    private ConsultEvidences consultEvidences;

    @Autowired
    private DeleteEvidence deleteEvidence;

    @GetMapping(path = "/consultEvidences", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EvidenceDTO>> seeEvidence() {
        try {
            return ResponseEntity.ok(consultEvidences.consultEvidences());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping(path = "/deteleEvidence/{idEvidencia}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteEvidence(@PathVariable Long idEvidencia) {
        try {
            deleteEvidence.deleteById(idEvidencia);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
