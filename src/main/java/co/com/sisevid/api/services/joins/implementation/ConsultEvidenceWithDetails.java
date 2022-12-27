package co.com.sisevid.api.services.joins.implementation;

import co.com.sisevid.api.dto.EvidenceWithDetailsDTO;
import co.com.sisevid.api.entities.Evidence;
import co.com.sisevid.api.entities.EvidenceDetails;
import co.com.sisevid.api.repositoty.EvidenceDetailsRepository;
import co.com.sisevid.api.repositoty.EvidenceRepository;
import co.com.sisevid.api.services.joins.ConsultEvidenceWithDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultEvidenceWithDetails implements ConsultEvidenceWithDetailsService {
    @Autowired
    EvidenceDetailsRepository evidenceDetailsRepository;

    @Autowired
    EvidenceRepository evidenceRepository;

    @Override
    public List<EvidenceWithDetailsDTO> consultEvidenceWithDetails() {
        List<Evidence> evidenceList = evidenceRepository.findAll();
        EvidenceWithDetailsDTO evidenceWithDetailsDTO = new EvidenceWithDetailsDTO();
        ;
        List<EvidenceWithDetailsDTO> evidenceWithDetailsDTOList = new ArrayList<>();
        for (Evidence evidenceDB : evidenceList) {
            List<EvidenceDetails> evidenceDetailsListDB = evidenceDetailsRepository.findByEvidenceId(evidenceDB.getId());

            for (EvidenceDetails evidenceDetails : evidenceDetailsListDB) {
                evidenceWithDetailsDTO = new EvidenceWithDetailsDTO();
                System.out.println(evidenceDetails);
                if (evidenceDetails.getActive().equalsIgnoreCase("S")) {
                    evidenceWithDetailsDTO.setEvidenceDetail(evidenceDetails);
                    if (evidenceDetails.getStatus().equalsIgnoreCase("2")) {
                        evidenceWithDetailsDTO.setStatus("Verificada");
                    } else if (evidenceDetails.getStatus().equalsIgnoreCase("3")) {
                        evidenceWithDetailsDTO.setStatus("Verificada y validada");
                    } else {
                        evidenceWithDetailsDTO.setStatus("No verificada");
                    }
                    break;
                }
            }

            if (!evidenceDetailsListDB.isEmpty()) {
                evidenceWithDetailsDTO.setId(evidenceDB.getId());
                evidenceWithDetailsDTO.setTitle(evidenceDB.getTitle());
                evidenceWithDetailsDTO.setDescription(evidenceDB.getDescription());
                evidenceWithDetailsDTO.setType(evidenceDB.getType());
                evidenceWithDetailsDTO.setTypeFile(evidenceDB.getTypeFile());
                evidenceWithDetailsDTO.setEvidenceCreationDate(evidenceDB.getEvidenceCreationDate());
                evidenceWithDetailsDTO.setEvidenceRegisterDate(evidenceDB.getEvidenceRegisterDate());
                evidenceWithDetailsDTO.setAuthors(evidenceDB.getAuthors());
                evidenceWithDetailsDTO.setObservation(evidenceDB.getObservation());
                evidenceWithDetailsDTO.setUserCreate(evidenceDB.getUserCreate());
                evidenceWithDetailsDTO.setCreationDate(evidenceDB.getCreationDate());

                evidenceWithDetailsDTOList.add(evidenceWithDetailsDTO);
            }

        }
        return evidenceWithDetailsDTOList;
    }
}
