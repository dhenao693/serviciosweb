package co.com.sisevid.api.dto.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateJwtDto {
    private boolean isValidAccessToken;
}
