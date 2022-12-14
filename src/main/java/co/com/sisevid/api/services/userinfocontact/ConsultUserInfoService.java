package co.com.sisevid.api.services.userinfocontact;

import co.com.sisevid.api.dto.UserInfoContactDTO;
import co.com.sisevid.api.entities.UserInfoContact;

public interface ConsultUserInfoService {
    public UserInfoContactDTO consultUserInfo(Long id);
}
