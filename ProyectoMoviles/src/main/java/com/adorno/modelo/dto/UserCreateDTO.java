package com.adorno.modelo.dto;
/*
 * Objeto inmutable
 */
public record UserCreateDTO(String email, String username, String password, String... roles) {}
