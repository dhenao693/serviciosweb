package co.com.sisevid.api.services.joins.implementation;

import co.com.sisevid.api.dto.EvidenceWithDetailsDTO;
import co.com.sisevid.api.repositoty.EvidenceDetailsRepository;
import co.com.sisevid.api.repositoty.EvidenceRepository;
import co.com.sisevid.api.services.joins.CreateEvidenceWithDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateEvidenceWithDetails implements CreateEvidenceWithDetailsService {
    @Autowired
    EvidenceDetailsRepository evidenceDetailsRepository;

    @Autowired
    EvidenceRepository evidenceRepository;

    @Override
    public void createEvidenceWithDetails(EvidenceWithDetailsDTO evidenceWithDetailsDTO) {

    }
}
