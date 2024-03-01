package com.adorno.security.jwt;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity.JwtSpec;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
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
		
		try {
			getAllClaims(token);
			return true;
		}catch (Exception e) {
			log.error("JwtUtils: toke invalido"+ e.getMessage());
			return false;
		}
	}
	
	// Obtener userName por token
	public String getUserNameFromToke(String token) {
		// pararse a verlo min 21-23
		return getClaim(token, Claims::getSubject); // le mandamos que tipo de dato convertira
	}
	
	/**
	 * Genera la parte secreta
	 * @return SecrectKey 
	 */
	private SecretKey getSignatureKey() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
	}
	
	private Claims getAllClaims(String token) {
		return Jwts.parser()
				.verifyWith(getSignatureKey())
				.build()
				.parseSignedClaims(token).getPayload();
	}
	
	// WHATHEFOKO
	private <T> T getClaim(String token, Function<Claims, T> claimsFunction) {
		Claims allClaims = getAllClaims(token);
		return claimsFunction.apply(allClaims);
	}
	
	// public Boolean 
	
	
	// Falta algo de claims 
}
