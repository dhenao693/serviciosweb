package com.itm.servicioswebmaven.builders;

import com.itm.servicioswebmaven.dto.UserDto;
import com.itm.servicioswebmaven.entities.User;

public class UserBuilder {
    private static User user = new User();
    private static UserDto userDto = new UserDto();

    public static User userDefault(){
        user.setDocument(12345);
        user.setUser("admin1234");
        user.setPassword("admin1234");
        user.setName("Default");
        user.setLastname("Default");
        return user;
    }

    public static UserDto userDtoDefault(){
        userDto.setDocument(12345);
        userDto.setUser("admin1234");
        userDto.setPassword("admin1234");
        userDto.setName("Default");
        userDto.setLastname("Default");
        return userDto;
    }
}
