package co.com.sisevid.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserInfoContactDTO {

    private long id;
    private String documentType;
    private String documentNumber;
    private String name;
    private String lastName;
    private String phone;
    private String email;
    private String userCreate;
    private String dateCreate;
}
