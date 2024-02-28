package com.adorno.services;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.adorno.modelo.dto.UserCreateDTO;
import com.adorno.modelo.mapper.UserMapper;
import com.adorno.modelo.sqlSecurity.ERole;
import com.adorno.modelo.sqlSecurity.RoleEntity;
import com.adorno.modelo.sqlSecurity.UserEntity;
import com.adorno.repositorio.RoleRepository;
import com.adorno.repositorio.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final UserMapper userCreateDTO2UserMapper;

	public UserService(UserRepository userRepository, RoleRepository roleRepository,
			UserMapper userCreateDTO2UserMapper) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userCreateDTO2UserMapper = userCreateDTO2UserMapper;
	}

	// igual es momento de usar Response
	public boolean createUser(UserCreateDTO userCreateDTO) {
		UserEntity user = userCreateDTO2UserMapper.mapToEntity(userCreateDTO);
		if (userCreateDTO.roles() != null) {
			Set<RoleEntity> roles = fillRoles(userCreateDTO.roles());
			user.setRoles(roles);
		}
		if (userRepository.save(user) != null) {
			return true;
		}
		return false;
	}

	private Set<RoleEntity> fillRoles(String[] t) {
		if (ERole.validate(t)) {
			return Arrays.asList(t).stream()
					.map((rol) -> {
							ERole rolresult = ERole.getRole(rol).get();
							Optional<RoleEntity> byName = roleRepository.findByName(rolresult);
							RoleEntity roleEntity = byName.get();
							return roleEntity;
						})
					.collect(Collectors.toSet());
		}
		return null;
	}

	public boolean delete(String username) {
		Optional<UserEntity> byUsername = userRepository.findByUsername(username);
		userRepository.delete(byUsername.get());
//		userRepository.deleteByUsername(username);
		return true;
	}
}