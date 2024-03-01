package com.adorno.services;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adorno.modelo.sqlSecurity.UserEntity;
import com.adorno.repositorio.UserRepository;

import lombok.extern.slf4j.Slf4j;
/*
 * Servicio dedicado a  obetener los datos del usuario
 */

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UserRepository userRepo;
	
	
	public UserDetailsServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Obtener userEntity de la bbdd y sus roles,
		UserEntity user = Optional.of(this.userRepo.findByUsername(username).get(0))
					.orElseThrow(() -> new  UsernameNotFoundException("usuario existente"));
		// Conviertiendo roles de UserEntity a la Clase Roles de Spring Security
		Set<SimpleGrantedAuthority> setRoles =	user.getRoles().stream()
					// Se pone "ROLE_"+.. porque los roles empiezan asi en SPRING
					.map((rol) -> new SimpleGrantedAuthority("ROLE_"+rol.getName().name()))
					.collect(Collectors.toSet());
		log.debug("UserDetailsServiceImpl: load user"+user.getUsername());
		
		// Creamos un usuario de Spring
		User userSpring = new User(user.getUsername(), user.getPassword(), setRoles);
		
		return userSpring;
	}

}
