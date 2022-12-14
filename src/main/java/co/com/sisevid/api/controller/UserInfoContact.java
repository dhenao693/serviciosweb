package co.com.sisevid.api.controller;

import co.com.sisevid.api.dto.UserDto;
import co.com.sisevid.api.dto.UserInfoContactDTO;
import co.com.sisevid.api.services.user.CreateUserService;
import co.com.sisevid.api.services.user.implementation.ConsultUser;
import co.com.sisevid.api.services.user.implementation.ConsultUsers;
import co.com.sisevid.api.services.userinfocontact.ConsultUserInfoService;
import co.com.sisevid.api.services.userinfocontact.implementation.ConsultUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userinfocontact")
public class UserInfoContact {

    @Autowired
    private ConsultUserInfo consultUserInfo;

    @GetMapping(path = "/consultUserInfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserInfoContactDTO> consultUserInfo(@RequestParam("id") Long id) {
        try {
            return ResponseEntity.ok(consultUserInfo.consultUserInfo(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
