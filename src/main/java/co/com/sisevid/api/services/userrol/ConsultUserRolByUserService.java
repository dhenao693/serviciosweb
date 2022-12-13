package co.com.sisevid.api.services.userrol;

import co.com.sisevid.api.dto.UserRolDTO;

import java.util.List;

public interface ConsultUserRolByUserService {
    public List<UserRolDTO> consultUserRolsByUser(Long userId);
}
