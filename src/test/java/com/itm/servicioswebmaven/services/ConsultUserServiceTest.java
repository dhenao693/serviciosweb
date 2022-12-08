package com.itm.servicioswebmaven.services;

import com.itm.servicioswebmaven.dto.UserDto;
import com.itm.servicioswebmaven.repositoty.UserRepository;
import com.itm.servicioswebmaven.services.implementation.ConsultUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.itm.servicioswebmaven.builders.UserBuilder.userDtoDefault;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ConsultUserServiceTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    private ConsultUser consultUser;

    private UserDto user;

    @BeforeEach
    public void inicializa() {
        user = userDtoDefault();
    }

    @Test
    void testConsultUser() {
        consultUser = new ConsultUser(userRepository);
        UserDto userDto = consultUser.consultUser(user.getUser());

        assertNotNull(userDto);
    }
}
