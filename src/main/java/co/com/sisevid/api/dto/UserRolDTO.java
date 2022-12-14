package co.com.sisevid.api.dto;

import co.com.sisevid.api.entities.Rol;
import co.com.sisevid.api.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRolDTO {
    private long id;
    private User user;
    private Rol rol;
}
