package co.com.sisevid.api.services.user;


import co.com.sisevid.api.dto.UserDto;

public interface UpdaterUserService {
    public Long updateUser(UserDto userDto, Long id);
}
