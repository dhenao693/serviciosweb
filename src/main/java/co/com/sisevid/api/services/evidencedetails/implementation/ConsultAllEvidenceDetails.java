package co.com.sisevid.api.services.evidencedetails.implementation;

import co.com.sisevid.api.dto.EvidenceDetailsDTO;
import co.com.sisevid.api.entities.EvidenceDetails;
import co.com.sisevid.api.repositoty.EvidenceDetailsRepository;
import co.com.sisevid.api.services.evidencedetails.ConsultAllEvidenceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ConsultAllEvidenceDetails implements ConsultAllEvidenceDetailsService {
    @Autowired
    EvidenceDetailsRepository evidenceDetailsRepository;

    @Autowired
    public ConsultAllEvidenceDetails(EvidenceDetailsRepository evidenceDetailsRepository) {
        this.evidenceDetailsRepository = evidenceDetailsRepository;
    }
    @Override
    public List<EvidenceDetailsDTO> consultAllEvidenceDetails() {
        List<EvidenceDetails> evidencesDetails = evidenceDetailsRepository.findAll();
        System.out.println(evidencesDetails);
        List<EvidenceDetailsDTO> evidencesDetailsDTO = new ArrayList<>();
        EvidenceDetailsDTO evidenceDetailsDTO;

        for (EvidenceDetails evidenceDetailsDB: evidencesDetails) {
            evidenceDetailsDTO = new EvidenceDetailsDTO();
            evidenceDetailsDTO.setId(evidenceDetailsDB.getId());
            evidenceDetailsDTO.setEvidenceId(evidenceDetailsDB.getEvidenceId());
            evidenceDetailsDTO.setUserUpdate(evidenceDetailsDB.getUserUpdate());
            evidenceDetailsDTO.setDateUpdate(evidenceDetailsDB.getDateUpdate());
            evidenceDetailsDTO.setStatus(evidenceDetailsDB.getStatus());
            evidenceDetailsDTO.setActive(evidenceDetailsDB.getActive());

            evidencesDetailsDTO.add(evidenceDetailsDTO);
        }

        return evidencesDetailsDTO;
    }
}
