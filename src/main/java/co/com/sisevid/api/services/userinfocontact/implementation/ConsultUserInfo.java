package co.com.sisevid.api.services.userinfocontact.implementation;

import co.com.sisevid.api.dto.UserInfoContactDTO;
import co.com.sisevid.api.entities.UserInfoContact;
import co.com.sisevid.api.repositoty.UserInfoContactRepository;
import co.com.sisevid.api.services.userinfocontact.ConsultUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultUserInfo implements ConsultUserInfoService {
    @Autowired
    UserInfoContactRepository userInfoContactRepository;

    @Autowired
    public ConsultUserInfo(UserInfoContactRepository userInfoContactRepository) {
        this.userInfoContactRepository = userInfoContactRepository;
    }

    @Override
    public UserInfoContactDTO consultUserInfo(Long id) {
        Optional<UserInfoContact> userInfoContact = userInfoContactRepository.findById(id);
        UserInfoContactDTO userInfoContactDTO = new UserInfoContactDTO();
        userInfoContactDTO.setId(userInfoContact.get().getId());
        userInfoContactDTO.setEmail(userInfoContact.get().getEmail());
        userInfoContactDTO.setName(userInfoContact.get().getName());
        userInfoContactDTO.setLastName(userInfoContact.get().getLastName());
        userInfoContactDTO.setDateCreate(userInfoContact.get().getDateCreate());
        userInfoContactDTO.setUserCreate(userInfoContact.get().getUserCreate());
        userInfoContactDTO.setPhone(userInfoContact.get().getPhone());
        userInfoContactDTO.setDocumentNumber(userInfoContact.get().getDocumentNumber());
        userInfoContactDTO.setDocumentType(userInfoContact.get().getDocumentType());
        return userInfoContactDTO;
    }
}
