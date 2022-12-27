package co.com.sisevid.api.services.evidencedetails.implementation;

import co.com.sisevid.api.dto.EvidenceDetailsDTO;
import co.com.sisevid.api.entities.EvidenceDetails;
import co.com.sisevid.api.repositoty.EvidenceDetailsRepository;
import co.com.sisevid.api.services.evidencedetails.ConsultEvidenceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultEvidenceDetails implements ConsultEvidenceDetailsService {
    @Autowired
    EvidenceDetailsRepository evidenceDetailsRepository;

    @Autowired
    public ConsultEvidenceDetails(EvidenceDetailsRepository evidenceDetailsRepository) {
        this.evidenceDetailsRepository = evidenceDetailsRepository;
    }

    @Override
    public List<EvidenceDetailsDTO> consultEvidenceDetails(Long evidenceId) {
        List<EvidenceDetails> evidencesDetails = evidenceDetailsRepository.findByEvidenceId(evidenceId);
        System.out.println(evidencesDetails);
        List<EvidenceDetailsDTO> evidencesDetailsDTO = new ArrayList<>();
        EvidenceDetailsDTO evidenceDetailsDTO;

        for (EvidenceDetails evidenceDetailsDB : evidencesDetails) {
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
