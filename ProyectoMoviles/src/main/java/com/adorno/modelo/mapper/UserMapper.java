package com.adorno.modelo.mapper;

import com.adorno.modelo.dto.UserCreateDTO;
import com.adorno.modelo.security.UserEntity;

public class UserMapper implements IMapper<UserCreateDTO, UserEntity> {

	@Override
	public UserCreateDTO mapToDTO(UserEntity k) {
		// Como carajos creamos un record? 
//		return new UserCreateDTO(k.getEmail(), k.getUsername(), k.getPassword(), k.getRoles());
		return null;
	}

	@Override
	public UserEntity mapToEntity(UserCreateDTO t) {
		return new UserEntity(t.email(), t.username(), t.password());
	}

}
