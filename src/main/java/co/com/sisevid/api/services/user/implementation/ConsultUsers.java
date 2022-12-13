package co.com.sisevid.api.services.user.implementation;

import co.com.sisevid.api.dto.UserDto;
import co.com.sisevid.api.entities.User;
import co.com.sisevid.api.repositoty.UserRepository;
import co.com.sisevid.api.services.user.ConsultUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultUsers implements ConsultUsersService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    public ConsultUsers(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> consultUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        UserDto userDto;
        List<User> userDBList = userRepository.findAll();
        for (User userDB: userDBList) {
            userDto = new UserDto();
            userDto.setId(userDB.getId());
            userDto.setUser(userDB.getUser());
            userDto.setPassword(userDB.getPassword());
            userDto.setDateCreate(userDB.getDateCreate());
            userDto.setUserCreate(userDB.getUserCreate());
            userDto.setIdUserInfo(userDB.getIdUserInfo());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
}
