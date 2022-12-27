package co.com.sisevid.api.services.user.implementation;

import co.com.sisevid.api.dto.UserDto;
import co.com.sisevid.api.entities.User;
import co.com.sisevid.api.repositoty.UserRepository;
import co.com.sisevid.api.services.user.ConsultUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultUser implements ConsultUserServices {
    @Autowired
    UserRepository userRepository;

    @Autowired
    public ConsultUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto consultUser(String user) {
        User userDB = userRepository.findByUser(user);
        UserDto userDto = new UserDto();
        userDto.setId(userDB.getId());
        userDto.setUser(userDB.getUser());
        userDto.setPassword(userDB.getPassword());
        userDto.setDateCreate(userDB.getDateCreate());
        userDto.setUserCreate(userDB.getUserCreate());
        userDto.setIdUserInfo(userDB.getIdUserInfo());
        return userDto;
    }


}
