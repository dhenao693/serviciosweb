package co.com.sisevid.api.services.evidence.implementation;

import co.com.sisevid.api.repositoty.EvidenceRepository;
import co.com.sisevid.api.services.evidence.DeleteEvideceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteEvidence implements DeleteEvideceService {
    @Autowired
    EvidenceRepository evidenceRepository;

    @Autowired
    public DeleteEvidence(EvidenceRepository evidenceRepository) {
        this.evidenceRepository = evidenceRepository;
    }


    @Override
    public void deleteById(Long idEvidence) {
        evidenceRepository.deleteById(idEvidence);

    }
}
