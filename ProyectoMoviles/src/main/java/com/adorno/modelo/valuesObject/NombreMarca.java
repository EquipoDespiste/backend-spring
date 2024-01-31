package com.adorno.modelo.valuesObject;

public class NombreMarca {
private final String nombre;

public NombreMarca(String nombre) {
	if( !validarLongitudNombre(nombre)) {
		throw new IllegalArgumentException("El nombre no cumple con la longitud de 60 caracteres  "+nombre);
	}
	this.nombre = nombre;
}

public String getNombre() {
	return nombre;
}


private boolean validarLongitudNombre(String nombre) {
	return nombre.length()<=60;
}
}