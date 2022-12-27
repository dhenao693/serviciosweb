package co.com.sisevid.api.dto;

import co.com.sisevid.api.entities.UserInfoContact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private UserInfoContact idUserInfo;
    private String password;
    private String user;
    private String userCreate;
    private String dateCreate;
}
