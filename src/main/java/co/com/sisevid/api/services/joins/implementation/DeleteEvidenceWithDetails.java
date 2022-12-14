package co.com.sisevid.api.services.joins.implementation;

import co.com.sisevid.api.entities.EvidenceDetails;
import co.com.sisevid.api.repositoty.EvidenceDetailsRepository;
import co.com.sisevid.api.repositoty.EvidenceRepository;
import co.com.sisevid.api.services.joins.DeleteEvidenceWithDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteEvidenceWithDetails implements DeleteEvidenceWithDetailsService {
    @Autowired
    EvidenceRepository evidenceRepository;

    @Autowired
    EvidenceDetailsRepository evidenceDetailsRepository;

    @Override
    public void deleteEvidenceWith(Long idEvidence) {
        List<EvidenceDetails> evidenceDetailsList = evidenceDetailsRepository.findByEvidenceId(idEvidence);
        for (EvidenceDetails evidenceDetails : evidenceDetailsList) {
            evidenceDetailsRepository.deleteById(evidenceDetails.getId());
        }
        evidenceRepository.deleteById(idEvidence);
    }
}
