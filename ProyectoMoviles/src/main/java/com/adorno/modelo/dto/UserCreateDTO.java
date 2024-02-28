package com.adorno.modelo.dto;

public record UserCreateDTO(
		String email,
		String username,
		String password,
		String... roles
		) {}
