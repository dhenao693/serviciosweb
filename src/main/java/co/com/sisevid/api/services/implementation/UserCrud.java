package co.com.sisevid.api.services.implementation;

import co.com.sisevid.api.entities.User;
import co.com.sisevid.api.repositoty.UserCrudRepository;
import co.com.sisevid.api.services.UserCrudServices;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserCrud implements UserCrudServices {
    private final UserCrudRepository userCrudRepository;

    public UserCrud(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }


    public User save(User user) {
        return userCrudRepository.save(user);
    }

    public void delete(Long id) throws EntityNotFoundException {
        if (userCrudRepository.findById(id).isPresent()) {
            userCrudRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("The client does not exist");
        }
    }

    public List<User> findByFilters(Long id, String idUserInfo, String user, String password, String userCreate, String dateCreate) throws EntityNotFoundException {
        return userCrudRepository.findByFilters(id, idUserInfo, user, password, userCreate, dateCreate);
    }
}
