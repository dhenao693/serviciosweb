package co.com.sisevid.api.services.evidence.implementation;

import co.com.sisevid.api.dto.EvidenceDTO;
import co.com.sisevid.api.entities.Evidence;
import co.com.sisevid.api.repositoty.EvidenceRepository;
import co.com.sisevid.api.services.evidence.ConsultEvidencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultEvidences implements ConsultEvidencesService {
    @Autowired
    EvidenceRepository evidenceRepository;

    @Autowired
    public ConsultEvidences(EvidenceRepository evidenceRepository) {
        this.evidenceRepository = evidenceRepository;
    }

    @Override
    public List<EvidenceDTO> consultEvidences() {
        List<EvidenceDTO> evidenceDTOList = new ArrayList<>();
        EvidenceDTO evidenceDTO;
        List<Evidence> rolList = evidenceRepository.findAll();
        for (Evidence evidenceDB : rolList) {
            evidenceDTO = new EvidenceDTO();
            evidenceDTO.setId(evidenceDB.getId());
            evidenceDTO.setTitle(evidenceDB.getTitle());
            evidenceDTO.setDescription(evidenceDB.getDescription());
            evidenceDTO.setType(evidenceDB.getType());
            evidenceDTO.setTypeFile(evidenceDB.getTypeFile());
            evidenceDTO.setEvidenceCreationDate(evidenceDB.getEvidenceCreationDate());
            evidenceDTO.setEvidenceRegisterDate(evidenceDB.getEvidenceRegisterDate());
            evidenceDTO.setAuthors(evidenceDB.getAuthors());
            evidenceDTO.setObservation(evidenceDB.getObservation());
            evidenceDTO.setUserCreate(evidenceDB.getUserCreate());
            evidenceDTO.setCreationDate(evidenceDB.getCreationDate());
            evidenceDTOList.add(evidenceDTO);
        }
        return evidenceDTOList;
    }

    public List<Evidence> consultEvidences2() {
        return evidenceRepository.findAll();
    }
}
