package co.com.sisevid.api.services.evidencedetails.implementation;

import co.com.sisevid.api.repositoty.EvidenceDetailsRepository;
import co.com.sisevid.api.services.evidencedetails.DeleteEvidenceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteEvidenceDetails implements DeleteEvidenceDetailsService {
    @Autowired
    EvidenceDetailsRepository evidenceDetailsRepository;

    @Autowired
    public DeleteEvidenceDetails(EvidenceDetailsRepository evidenceDetailsRepository) {
        this.evidenceDetailsRepository = evidenceDetailsRepository;
    }

    @Override
    public void deleteByEvidenceId(Long idsEvidence) {
        evidenceDetailsRepository.deleteById(idsEvidence);
    }
}
