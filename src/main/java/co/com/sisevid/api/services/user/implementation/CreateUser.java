package co.com.sisevid.api.services.user.implementation;

import co.com.sisevid.api.dto.UserDto;
import co.com.sisevid.api.repositoty.UserRepository;
import co.com.sisevid.api.services.user.CreateUserService;
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
    public UserDto createUser(UserDto user) {
        return null;
    }
}
