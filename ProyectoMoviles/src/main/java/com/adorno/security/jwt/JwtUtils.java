package com.adorno.security.jwt;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity.JwtSpec;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtils {
	
	// Generador de llave encriptada : https://asecuritysite.com/encryption/plain
	// https://jwt.io/
	@Value("${jwt.secret.key}") // no es de Lombok
	private String secretKey;
	@Value("${jwt.time.expiration}") // no es de Lombok
	private String timeExpiration; // Tiempo de expiracion del token
	
	// Creador de token
	/**
	 * Generar un token de acceso
	 * @param username
	 * @return
	 */
	public String generateAccessToken(String username) {
//		primer Date de sql
		Date fechaCaducidad = Date.valueOf(LocalDate.now().plus(1,ChronoUnit.DAYS));
		
		String compact = Jwts
				.builder()
				// Fecha para que caduque
				.issuedAt(fechaCaducidad) 
				.subject(username)
				// La parte secreta
				.signWith(getSignatureKey())
				.compact();
		
		log.debug("JwtUtils: Creando token: "+compact);
		return compact;
	}
	
	// Validador de Tokens
	public Boolean isTokenValid(String token) {
		return null;
	}
	
	// Obtener userName por token
	public String getUserNameFromToke(String token) {
		return null;
	}
	
	/**
	 * Genera la parte secreta
	 * @return SecrectKey 
	 */
	private SecretKey getSignatureKey() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
	}
	
	// Falta algo de claims 
}
