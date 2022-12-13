package co.com.sisevid.api.services.rols.implementation;

import co.com.sisevid.api.dto.RolDTO;
import co.com.sisevid.api.entities.Rol;
import co.com.sisevid.api.repositoty.RolRepository;
import co.com.sisevid.api.services.rols.ConsultRolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultRols implements ConsultRolsService {
    @Autowired
    RolRepository rolRepository;

    @Autowired
    public ConsultRols(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<RolDTO> consultRols() {
        List<RolDTO> rolDTOList = new ArrayList<>();
        RolDTO rolDTO;
        List<Rol> rolList = rolRepository.findAll();
        for (Rol rolDB: rolList) {
            rolDTO = new RolDTO();
            rolDTO.setId(rolDB.getId());
            rolDTO.setDescription(rolDB.getDescription());
            rolDTO.setCreateUser(rolDB.getCreateUser());
            rolDTO.setCreateDate(rolDB.getCreateDate());
            rolDTOList.add(rolDTO);
        }
        return rolDTOList;
    }
}
