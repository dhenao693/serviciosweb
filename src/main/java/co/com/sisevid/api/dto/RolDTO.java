package co.com.sisevid.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RolDTO {
    private long id;
    private String description;
    private String createUser;
    private String createDate;
}
