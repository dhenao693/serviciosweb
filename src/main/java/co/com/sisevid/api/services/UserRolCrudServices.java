package co.com.sisevid.api.services;

import co.com.sisevid.api.entities.Rol;
import co.com.sisevid.api.entities.User;
import co.com.sisevid.api.entities.UserRol;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface UserRolCrudServices {
    UserRol save(final UserRol userRol);

    void delete(final Long id) throws EntityNotFoundException;

    List<UserRol> findByFilters(Long id, User user, Rol rol)
            throws EntityNotFoundException;
}