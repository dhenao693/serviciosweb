package com.itm.servicioswebmaven.controller;

import com.itm.servicioswebmaven.dto.UserDto;
import com.itm.servicioswebmaven.services.implementation.ConsultUser;
import com.itm.servicioswebmaven.services.implementation.ConsultUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private ConsultUser consultUser;

    @Autowired
    private ConsultUsers consultUsers;

    @GetMapping(path = "/consultUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> seeUsers() {
        try {
            return ResponseEntity.ok(consultUsers.consultUsers());
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(path = "/consultUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> verEmpleados(@RequestParam("user") String user) {
        try {
            return ResponseEntity.ok(consultUser.consultUser(user));
        } catch (Exception e) {
            return null;
        }
    }
}
