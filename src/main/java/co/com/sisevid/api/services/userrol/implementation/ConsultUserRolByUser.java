package co.com.sisevid.api.services.userrol.implementation;

import co.com.sisevid.api.dto.UserRolDTO;
import co.com.sisevid.api.entities.User;
import co.com.sisevid.api.services.userrol.ConsultUserRolByUserService;

import java.util.List;
import co.com.sisevid.api.dto.UserRolDTO;
import co.com.sisevid.api.entities.UserRol;
import co.com.sisevid.api.repositoty.UserRolRepository;
import co.com.sisevid.api.services.userrol.ConsultUserRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultUserRolByUser implements ConsultUserRolByUserService {
    @Autowired
    UserRolRepository userRolRepository;

    @Autowired
    public ConsultUserRolByUser(UserRolRepository userRolRepository) {
        this.userRolRepository = userRolRepository;
    }

    @Override
    public List<UserRolDTO> consultUserRolsByUser(Long userId) {
        List<UserRol> userRolList = userRolRepository.findByUser(userId);
        System.out.println(userRolList);


        return null;
    }
}
