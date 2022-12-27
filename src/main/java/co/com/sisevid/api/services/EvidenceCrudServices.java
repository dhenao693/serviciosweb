package co.com.sisevid.api.services;

import co.com.sisevid.api.entities.Evidence;

import javax.persistence.EntityNotFoundException;

public interface EvidenceCrudServices {
    Evidence save(final Evidence client);

    void delete(final Long id) throws EntityNotFoundException;

    Iterable<Evidence> findByFilters(final Long id, final String fullName, final String businessName, final String email, final String phone)
            throws EntityNotFoundException;
}
