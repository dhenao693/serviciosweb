package co.com.sisevid.api.services.implementation;

import co.com.sisevid.api.entities.Evidence;
import co.com.sisevid.api.repositoty.EvidenceCrudRepository;
import co.com.sisevid.api.services.EvidenceCrudServices;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EvidencesCrud implements EvidenceCrudServices {
    private final EvidenceCrudRepository evidenceCrudRepository;

    public EvidencesCrud(EvidenceCrudRepository evidenceCrudRepository) {
        this.evidenceCrudRepository = evidenceCrudRepository;
    }

    public Evidence save(Evidence evidence) {
        return evidenceCrudRepository.save(evidence);
    }

    public void delete(Long id) throws EntityNotFoundException {
        if (evidenceCrudRepository.findById(id).isPresent()) {
            evidenceCrudRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("The client does not exist");
        }

    }

    public List<Evidence> findByFilters(Long id, String title, String description, String type, String typeFile,
                                        String evidenceCreationDate, String evidenceRegisterDate, String authors,
                                        String observation, String userCreate, String creationDate) throws EntityNotFoundException {
        return evidenceCrudRepository.findByFilters(id, title, description, type, typeFile,
                evidenceCreationDate, evidenceRegisterDate, authors, observation, userCreate, creationDate);
    }
}
