package com.itm.servicioswebmaven.services;

import com.itm.servicioswebmaven.dto.UserDto;

public interface UpdaterUserService {
	public Long updateUser(UserDto userDto, Long id);
}
