package com.itm.servicioswebmaven.services.implementation;

import com.itm.servicioswebmaven.dto.UserDto;
import com.itm.servicioswebmaven.repositoty.UserRepository;
import com.itm.servicioswebmaven.services.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUser implements CreateUserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    public CreateUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto empleado) {
        return null;
    }
}
