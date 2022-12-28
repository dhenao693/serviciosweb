package co.com.sisevid.api.services;

import co.com.sisevid.api.entities.User;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface UserCrudServices {
    User save(final User user);

    void delete(final Long id) throws EntityNotFoundException;

    List<User> findByFilters(Long id, String idUserInfo, String user, String password, String userCreate, String dateCreate)
            throws EntityNotFoundException;
}
