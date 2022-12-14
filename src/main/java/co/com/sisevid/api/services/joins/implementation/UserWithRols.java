package co.com.sisevid.api.services.joins.implementation;

import co.com.sisevid.api.dto.RolDTO;
import co.com.sisevid.api.dto.UserWithRolsDTO;
import co.com.sisevid.api.entities.Rol;
import co.com.sisevid.api.entities.User;
import co.com.sisevid.api.entities.UserRol;
import co.com.sisevid.api.repositoty.RolRepository;
import co.com.sisevid.api.repositoty.UserRepository;
import co.com.sisevid.api.repositoty.UserRolRepository;
import co.com.sisevid.api.services.joins.UserWithRolsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserWithRols implements UserWithRolsServices {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    UserRolRepository userRolRepository;

    @Override
    public UserWithRolsDTO consultUserWithRols(String user) {
        User userDB =  userRepository.findByUser(user);

        UserWithRolsDTO userWithRolsDTO = new UserWithRolsDTO();
        userWithRolsDTO.setId(userDB.getId());
        userWithRolsDTO.setUser(userDB.getUser());
        userWithRolsDTO.setPassword(userDB.getPassword());
        userWithRolsDTO.setIdUserInfo(userDB.getIdUserInfo());

        List<UserRol> userRolDBList = userRolRepository.findByUser(userDB.getId());
        List<Long> idList = new ArrayList<>();
        for (UserRol userRol: userRolDBList) {
            idList.add(userRol.getRol().getId());
        }
        List<Rol> rolDBList = rolRepository.findAllById(idList);
        List<RolDTO> rolList = new ArrayList<>();
        RolDTO rolDTO;

        for (Rol rolDB :rolDBList) {
            rolDTO = new RolDTO();
            Optional<Rol> rol = rolRepository.findById(rolDB.getId());
            rolDTO.setId( rol.get().getId());
            rolDTO.setDescription( rol.get().getDescription());
            rolDTO.setCreateUser(rol.get().getCreateUser());
            rolDTO.setCreateDate(rol.get().getCreateDate());
            rolList.add(rolDTO);
        }


        userWithRolsDTO.setRolDTOList(rolList);
        return userWithRolsDTO;
    }
}
