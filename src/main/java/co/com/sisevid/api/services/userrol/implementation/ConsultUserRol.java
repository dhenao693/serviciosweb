package co.com.sisevid.api.services.userrol.implementation;

import co.com.sisevid.api.dto.UserRolDTO;
import co.com.sisevid.api.entities.UserRol;
import co.com.sisevid.api.repositoty.UserRolRepository;
import co.com.sisevid.api.services.userrol.ConsultUserRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultUserRol implements ConsultUserRolService {
    @Autowired
    UserRolRepository userRolRepository;

    @Autowired
    public ConsultUserRol(UserRolRepository userRolRepository) {
        this.userRolRepository = userRolRepository;
    }

    @Override
    public List<UserRolDTO> consultUsersRols() {
        List<UserRolDTO> userRolDTOList = new ArrayList<>();
        UserRolDTO userRolDTO;
        List<UserRol> userDBList = userRolRepository.findAll();
        for (UserRol userRolDB: userDBList) {
            userRolDTO = new UserRolDTO();
            userRolDTO.setId(userRolDB.getId());
            userRolDTO.setUser(userRolDB.getUser());
            userRolDTO.setRol(userRolDB.getRol());
            userRolDTOList.add(userRolDTO);
        }
        return userRolDTOList;

    }
}
