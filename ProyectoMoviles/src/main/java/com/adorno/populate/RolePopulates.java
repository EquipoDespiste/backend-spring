package com.adorno.populate;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.adorno.modelo.dto.UserCreateDTO;
import com.adorno.modelo.sqlSecurity.ERole;
import com.adorno.modelo.sqlSecurity.RoleEntity;
import com.adorno.repositorio.RoleRepository;
import com.adorno.services.UserService;

import jakarta.annotation.PostConstruct;

@Component
public class RolePopulates {
	private final RoleRepository roleRepository;
	private final UserService userService;
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String bbddStatus;

	public RolePopulates(RoleRepository roleRepository, UserService userService) {
		super();
		this.roleRepository = roleRepository;
		this.userService = userService;
	}

	//debido al orden en que se cargan las clases de Spring
	//hay que asegurarse de que algunas cosas van al final
	@PostConstruct
	public void init() {
		if (!bbddStatus.equals("update")) {
			populateRoles();
			populateUsers();
		}
	}
	public void populateRoles() {
		for (ERole erole : ERole.values()) {
			if (roleRepository.findByName(erole).isEmpty())
				roleRepository.save(new RoleEntity(erole));
		}
	}
	public void populateUsers() {
		UserCreateDTO userCreateDTO = new UserCreateDTO("alumnoDesaparecido@extremadura.es", "Rangel", new BCryptPasswordEncoder().encode("1234"), "ADMIN","USER");

		List<UserCreateDTO> users=new ArrayList<>();
		users.add(userCreateDTO);
		users.add(new UserCreateDTO("efaditos@fontenia.es", "Lna", new BCryptPasswordEncoder().encode("1234"), "USER"));
		users.add(new UserCreateDTO("musicologa@piano.es", "Inma", new BCryptPasswordEncoder().encode("1234"), "GUEST"));
		users.add(new UserCreateDTO("ElMilNombres@cantalGallo.es", "NachoIgnasiIgnacio", new BCryptPasswordEncoder().encode("1234"), "GUEST"));
		userService.createUser(userCreateDTO);
	}

}