package com.adorno.configurations.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class SecurityConfig {

	/*
	 * Apuntes:
	 * - Porque quitamos csrf:
	 * 		 Si estás construyendo una API RESTful
	 *   	donde las solicitudes no se realizan a través de formularios HTML, 
	 *   	sino mediante solicitudes AJAX o clientes que consumen la API 
	 *   	directamente, puedes desactivar CSRF ya que la amenaza CSRF se 
	 *   	reduce significativamente.
	 * - Pasos:
	 * 1) Diseñar filtro de seguridad: SecurityFilterChain
	 * 2) Manager de Usuarios: UserDetailsService
	 * 3) Manager de autentificacion: AuthenticationManager
	 */
	
	@Bean
	SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
		// El parametro HttpSecurity es un bean propio de Spring Security,
		// sera Spring quien lo inyecte
		
		return httpSecurity
				.csrf( (csf)-> csf.disable())
				.authorizeHttpRequests( (auth)-> {
						// Cualquiera puede acceder ( Login aqui)
						auth.requestMatchers("users/hello").permitAll();
						// Cualquiero otra peticion -> autentificacion
						auth.anyRequest().authenticated();
					})
				.sessionManagement((session) -> {
					// Para ver como controlamos las sesiones
					session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				})
				.httpBasic(Customizer.withDefaults()) // Esto es momentaneo
				.build();
	}
	
	/*
	 *  Crear un Bean que nos den detalles del usuario
	 *  Necesitamos un Manager para que identifique al usuario
	 *  este es InMemoryUserDetailsManager, y es el servicio de detallesUsuario
	 *  de Spring.
	 *  
	 *  Este servicion usara UserDetails para definir usuarios y manejar sus datos.
	 *   
	 */
	@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		// Cuando implementaod encriptador, debemos encriptar la contraseña
		String password = passwordEncoder().encode("1234");
		// este user es de .security.core.userdetails.User;
		UserDetails user = User.withUsername("santi")
								.password(password)
								.roles()
								.build();
		manager.createUser(user);
		log.info("SecurityConfig: "+ user.getPassword());
//		System.out.println("SecurityConfig: "+ user.getPassword());
		return manager;
	}

	
	/*
	 * Definir AuthenticationManager del paquete (.security.authentication.AuthenticationManager;)
	 * - Cuando un usuario intente autenticarse en el sistema, nos dara sus
	 * credenciales (username/password) y este manager usara el USerDetailsManager
	 * para saber si hay un usuario con esas credenciales en el sistema
	 */
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws Exception {
		
		return httpSecurity
				// Tenemos que utilizar este builder para tener el AuthenticationManager
				.getSharedObject(AuthenticationManagerBuilder.class) 
				.userDetailsService(userDetailsService()) 
				.passwordEncoder(passwordEncoder)
				.and() // de Momento luego cambiar, es para probar
				.build();
	}
	// Codificador (Encriptador)
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	// --------------- Antiguo -------------
	// Para probar (Encriptador Falso)
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return PlainTextPasswordEncoder.getInstance();
//	}
	// UserDetailsService sin criptar
//	@Bean
//	UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		// Cuando implementaod encriptador, debemos encriptar la contraseña
//		String password = "1234";
//		// este user es de .security.core.userdetails.User;
//		UserDetails user = User.withUsername("santi")
//				.password(password)
//				.roles()
//				.build();
//		manager.createUser(user);
//		return manager;
//	}

	
}


//-------------- Jose -----------------------------
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.adorno.security.jwt.JwtUtils;
//import com.adorno.security.jwt.filters.JwtAuthenticationFilter;
//import com.adorno.security.jwt.filters.JwtAuthorizationFilter;
//import com.adorno.services.UserDetailsServiceImpl;
//
//import lombok.extern.slf4j.Slf4j;
////Esto es Chuclado tal cual de jose
//@Configuration
//@Slf4j
//@EnableMethodSecurity
//public class SecurityConfig {
//	private final UserDetailsServiceImpl userDetailsServiceImpl;
//	private final JwtUtils jwtUtils;
//	private final JwtAuthorizationFilter jwtAuthorizationFilter;
//
//	public SecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl, JwtUtils jwtUtils,
//			JwtAuthorizationFilter jwtAuthorizationFilter) {
//		super();
//		this.userDetailsServiceImpl = userDetailsServiceImpl;
//		this.jwtUtils = jwtUtils;
//		this.jwtAuthorizationFilter = jwtAuthorizationFilter;
//	}
//
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager)
//			throws Exception {
//		// aqui vamos a poner la autenticacion de jwt
//		JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtUtils);
//		jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
//		jwtAuthenticationFilter.setFilterProcessesUrl("/login");
//		// aqui el resto de la autenticacion
//		DefaultSecurityFilterChain httpsec = 
//				httpSecurity
//				.csrf((cs) -> cs.disable())
//				.authorizeHttpRequests((auth) -> {
//						auth.requestMatchers("users/hello").permitAll();
////						auth.requestMatchers("users/helloSecured").hasAnyRole("ADMIN");
//						auth.anyRequest().authenticated();
//						})
//				.sessionManagement((sess) -> {
//						sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//						})
//				.addFilter(jwtAuthenticationFilter)
//				.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
//				.build();
//		log.info("SecurityConfig:terminando configuracion config");
//		return httpsec;
//	}
//
//	/*
//	 * Este es el codificador que vamos a usar
//	 */
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	/*
//	 * Cuando un usuario intente autenticarse en el sistema, nos dara sus
//	 * credenciales (username/password) y este manager usara el USerDetailsManager
//	 * para saber si hay un usuario con esas credenciales en el sistema
//	 */
//	@Bean
//	AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder)
//			throws Exception {
//		AuthenticationManager authenticationManager = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
//				.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder).and().build();
//		log.debug("SecurityConfig:generando autentication manager");
//		return authenticationManager;
//	}
//}