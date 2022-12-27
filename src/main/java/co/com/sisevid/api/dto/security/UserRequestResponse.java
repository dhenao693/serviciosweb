package co.com.sisevid.api.dto.security;

import co.com.sisevid.api.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestResponse implements Serializable {

    private static final long serialVersionUID = -979112439818239436L;

    private UserDto user;

    private HttpServletRequest request;
}
