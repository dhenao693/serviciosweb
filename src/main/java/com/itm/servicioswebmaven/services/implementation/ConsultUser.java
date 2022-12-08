package com.itm.servicioswebmaven.services.implementation;

import com.itm.servicioswebmaven.dto.UserDto;
import com.itm.servicioswebmaven.entities.User;
import com.itm.servicioswebmaven.repositoty.UserRepository;
import com.itm.servicioswebmaven.services.ConsultUserServices;
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
        User userDB =  userRepository.findByUser(user);
        UserDto userDto = new UserDto();
        userDto.setDocument(userDB.getDocument());
        userDto.setUser(userDB.getUser());
        userDto.setName(userDB.getName());
        userDto.setPassword(userDB.getPassword());
        userDto.setLastname(userDB.getLastname());
        return userDto;
    }


}
