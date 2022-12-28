package co.com.sisevid.api.services;

import co.com.sisevid.api.entities.UserInfoContact;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface UserInfoCrudServices {
    UserInfoContact save(final UserInfoContact userInfoContact);

    void delete(final Long id) throws EntityNotFoundException;

    List<UserInfoContact> findByFilters(Long id, String documentType, String documentNumber, String name, String lastName, String phone, String email, String userCreate, String dateCreate)
            throws EntityNotFoundException;
}


