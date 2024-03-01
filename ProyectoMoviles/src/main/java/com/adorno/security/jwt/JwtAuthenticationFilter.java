package com.adorno.security.jwt;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.adorno.modelo.sqlSecurity.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private final JwtUtils jwtUtils;

	public JwtAuthenticationFilter(JwtUtils jwtUtils) {
		super();
		this.jwtUtils = jwtUtils;
	}
	// Metodos de UsernamePasswordAuthenticationFilter
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		UserEntity userEntity;
		String username ;
		String password;
		try {
			userEntity = new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);
			username= userEntity.getUsername();
			password = userEntity.getPassword();
			// Esto nos da un token basado en username y password
			UsernamePasswordAuthenticationToken authenticationToken 
						= new UsernamePasswordAuthenticationToken(username, password);
			
			Authentication authenticate = getAuthenticationManager().authenticate(authenticationToken);
			logger.debug("JwtAuthenticationFilter: terminado intento autenticate");
			return authenticate;
		} catch (Exception e) {
			e.printStackTrace();
			return super.attemptAuthentication(request, response);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// hemos de pillar el objeto autenticado
		User user = (User) authResult.getPrincipal();
		// hacemos un token de acceso con el username
		String accessToken = this.jwtUtils.generateAccessToken(user.getUsername());
		// escribimos el token en la cabecera
		response.addHeader("Authorization", accessToken);
		// Mapa donde vamosa air poneido propiedades 
		HashMap<String, Object> hasMap = new HashMap<String, Object>();
		hasMap.put("token", accessToken);
		hasMap.put("Message", "autenticacion correcta");
		hasMap.put("usuario", user.getUsername());
		
		response.setStatus(HttpStatus.OK.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		/*
		 * La respuesta no se trata como un objeto, si no como 
		 * un flujo. Hasta que no la cerramos se puede seguir
		 */
		response.getWriter().write(new ObjectMapper().writeValueAsString(hasMap));
		response.getWriter().flush();
		// para escribir en la respuesta
		
		super.successfulAuthentication(request, response, chain, authResult);
	}
	
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.unsuccessfulAuthentication(request, response, failed);
	}
}
