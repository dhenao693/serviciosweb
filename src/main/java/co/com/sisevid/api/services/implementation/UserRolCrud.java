package co.com.sisevid.api.services.implementation;

import co.com.sisevid.api.entities.Rol;
import co.com.sisevid.api.entities.User;
import co.com.sisevid.api.entities.UserRol;
import co.com.sisevid.api.repositoty.UserRolCrudRepository;
import co.com.sisevid.api.services.UserRolCrudServices;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserRolCrud implements UserRolCrudServices {
    private final UserRolCrudRepository userRolCrudRepository;

    public UserRolCrud(UserRolCrudRepository userRolCrudRepository) {
        this.userRolCrudRepository = userRolCrudRepository;
    }

    public UserRol save(UserRol userRol) {
        return userRolCrudRepository.save(userRol);
    }

    public void delete(Long id) throws EntityNotFoundException {
        if (userRolCrudRepository.findById(id).isPresent()) {
            userRolCrudRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("The client does not exist");
        }
    }

    public List<UserRol> findByFilters(Long id, User user, Rol rol) throws EntityNotFoundException {
        return null;
    }
}
