package co.com.sisevid.api.services.rols.implementation;

import co.com.sisevid.api.dto.RolDTO;
import co.com.sisevid.api.entities.Rol;
import co.com.sisevid.api.repositoty.RolRepository;
import co.com.sisevid.api.services.rols.ConsultRolByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultRolById implements ConsultRolByIdService {
    @Autowired
    RolRepository rolRepository;

    @Autowired
    public ConsultRolById(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public RolDTO consultRolsById(Long id) {
        RolDTO rolDTO = new RolDTO();
        Optional<Rol> rol = rolRepository.findById(id);
        rolDTO.setId(rol.get().getId());
        rolDTO.setDescription(rol.get().getDescription());
        rolDTO.setCreateUser(rol.get().getCreateUser());
        rolDTO.setCreateDate(rol.get().getCreateDate());
        return rolDTO;
    }
}
