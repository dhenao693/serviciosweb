package co.com.sisevid.api.services.implementation;

import co.com.sisevid.api.entities.Evidence;
import co.com.sisevid.api.repositoty.EvidenceCrudRepository;
import co.com.sisevid.api.services.EvidenceCrudServices;

import javax.persistence.EntityNotFoundException;

public class EvidencesCrudServices implements EvidenceCrudServices {
    private final EvidenceCrudRepository evidenceCrudRepository;

    public EvidencesCrudServices(EvidenceCrudRepository evidenceCrudRepository) {
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

    public Iterable<Evidence> findByFilters(Long id, String fullName, String businessName, String email, String phone) throws EntityNotFoundException {
        Iterable<Evidence> evidenceList = evidenceCrudRepository.findAll();
        return evidenceCrudRepository.findAll();
    }
}
