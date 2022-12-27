package co.com.sisevid.api.services;

import co.com.sisevid.api.entities.Evidence;

import javax.persistence.EntityNotFoundException;

public interface EvidenceCrudServices {
    Evidence save(final Evidence client);

    void delete(final Long id) throws EntityNotFoundException;

    Iterable<Evidence> findByFilters(Long id, String title, String description, String type, String typeFile,
                                     String evidenceCreationDate, String evidenceRegisterDate, String authors,
                                     String observation, String userCreate, String creationDate)
            throws EntityNotFoundException;
}
