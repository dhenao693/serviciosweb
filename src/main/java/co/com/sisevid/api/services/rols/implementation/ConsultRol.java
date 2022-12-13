package co.com.sisevid.api.services.rols.implementation;

import co.com.sisevid.api.dto.RolDTO;
import co.com.sisevid.api.entities.Rol;
import co.com.sisevid.api.repositoty.RolRepository;
import co.com.sisevid.api.services.rols.ConsultRolService;
import co.com.sisevid.api.services.rols.ConsultRolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ConsultRol implements ConsultRolService {
    @Autowired
    RolRepository rolRepository;

    @Autowired
    public ConsultRol(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }
    @Override
    public RolDTO consultRol(String description) {
        Rol rolDB =  rolRepository.findByDescription(description);
        RolDTO rolDTO = new RolDTO();
        rolDTO.setId(rolDB.getId());
        rolDTO.setDescription(rolDB.getDescription());
        rolDTO.setCreateUser(rolDB.getCreateUser());
        rolDTO.setCreateDate(rolDB.getCreateDate());
        return rolDTO;
    }
}
