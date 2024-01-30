package com.adorno.modelo.valuesObject;

public class NombreTecnologia {
private final String tecnologia;

public NombreTecnologia(String tecnologia) {
	if(!validacionNombreTecnologia(tecnologia)) {
		throw new IllegalArgumentException("El texto no cumple con la longitud de 60 caracteres "+tecnologia);
	}
	this.tecnologia = tecnologia;
}

public String getTecnologia() {
	return tecnologia;
}
private boolean validacionNombreTecnologia(String tecnologia) {
	return tecnologia.length()<=60;
}
}
