package co.com.sisevid.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private long id;
    private String idUserInfo;
    private String password;
    private String user;
    private String userCreate;
    private String dateCreate;
}
