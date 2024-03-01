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
			Optional<Set<RoleEntity>> roles = fillRoles(userCreateDTO.roles());
			if(roles.isPresent())
				user.setRoles(roles.get());
		}
		// Esta parte no me cuadra, no se porque Jose lo hace asi..
		// Segun la Doc, nunca retorna un valor null el metodo .save()
		// En todo caso si no se guarda tira un Error creo
//		if (userRepository.save(user) != null) {
//			return true;
//		}
		
		// TODO Si da tiempo que retorne Response.ok Response.bad
		try {
			this.userRepository.save(user);
			return true;
		}catch (Exception e) {			
			return false;
		}
	}

	private Optional<Set<RoleEntity>> fillRoles(String[] t) {
		if (ERole.validate(t)) {
			return Optional.of(
					Arrays.asList(t).stream()
					.map((rol) -> {
							ERole rolresult = ERole.getRole(rol).get();
							Optional<RoleEntity> byName = roleRepository.findByName(rolresult);
							RoleEntity roleEntity = byName.get();
							return roleEntity;
						})
					.collect(Collectors.toSet())
					);
		}
		// No se si asi queda feo
		return Optional.of(null);
	}

	public boolean delete(String username) {
		Optional<UserEntity> byUsername = userRepository.findByUsername(username);
		userRepository.delete(byUsername.get());
//		userRepository.deleteByUsername(username);
		return true;
	}
	
	
}