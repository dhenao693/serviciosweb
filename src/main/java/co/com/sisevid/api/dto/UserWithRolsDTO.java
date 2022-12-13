package co.com.sisevid.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserWithRolsDTO {
    private long id;
    private String idUserInfo;
    private String password;
    private String user;
    private List<RolDTO> rolDTOList;
}
