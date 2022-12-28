package co.com.sisevid.api.services.implementation;

import co.com.sisevid.api.entities.UserInfoContact;
import co.com.sisevid.api.repositoty.UserInfoCrudRepository;
import co.com.sisevid.api.services.UserInfoCrudServices;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserInfoCrud implements UserInfoCrudServices {
    private final UserInfoCrudRepository userInfoCrudRepository;

    public UserInfoCrud(UserInfoCrudRepository userInfoCrudRepository) {
        this.userInfoCrudRepository = userInfoCrudRepository;
    }

    public UserInfoContact save(UserInfoContact userInfoContact) {
        return userInfoCrudRepository.save(userInfoContact);
    }

    public void delete(Long id) throws EntityNotFoundException {
        if (userInfoCrudRepository.findById(id).isPresent()) {
            userInfoCrudRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("The client does not exist");
        }
    }

    public List<UserInfoContact> findByFilters(Long id, String documentType, String documentNumber, String name, String lastName, String phone, String email, String userCreate, String dateCreate) throws EntityNotFoundException {
        return null;
    }
}
