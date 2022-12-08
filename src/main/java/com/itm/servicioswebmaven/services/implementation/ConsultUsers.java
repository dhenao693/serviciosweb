package com.itm.servicioswebmaven.services.implementation;

import com.itm.servicioswebmaven.dto.UserDto;
import com.itm.servicioswebmaven.entities.User;
import com.itm.servicioswebmaven.repositoty.UserRepository;
import com.itm.servicioswebmaven.services.ConsultUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultUsers implements ConsultUsersService {
    private List<UserDto> userDtoList;

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
        for (User user: userDBList) {
            userDto = new UserDto();
            userDto.setDocument(user.getDocument());
            userDto.setUser(user.getUser());
            userDto.setPassword(user.getPassword());
            userDto.setName(user.getName());
            userDto.setLastname(user.getLastname());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
}
