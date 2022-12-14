package co.com.sisevid.api.dto;

import co.com.sisevid.api.entities.UserInfoContact;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserWithRolsDTO {
    private long id;
    private UserInfoContact idUserInfo;
    private String password;
    private String user;
    private List<RolDTO> rolDTOList;
}
