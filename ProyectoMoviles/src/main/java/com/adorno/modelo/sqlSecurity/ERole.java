package com.adorno.modelo.sqlSecurity;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

public enum ERole {
	ADMIN("ADMIN"), USER("USER"), GUEST("GUEST");
	private String name;
	
	private ERole(String name) {
		this.name = name;
	}

	public static Optional<ERole> getRole(String role) {
		return Arrays.asList(ERole.values()).stream().filter(e-> e.name.equals(role)).findFirst();
	}

	/*
	 * Valida si el Array de String son roles, si alguna no es directamente sale
	 * Nota: no le veo por ningun lado un ignoreCase(), quiere que siempre sea mayuscuals ? 
	 */
	public static boolean  validate(String[] t) {
		for (String string : t) {
			if(getRole(string).isEmpty()) return false;
		}
		return true;
	}
}