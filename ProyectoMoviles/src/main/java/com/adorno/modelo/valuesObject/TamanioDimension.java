package com.adorno.modelo.valuesObject;

public class TamanioDimension {
	public final float tamanio;

	public TamanioDimension(float tamanio) {
		if(!validarTamanio(tamanio)) {
			throw new IllegalArgumentException("El tamaño elegido debe se positivo "+tamanio);
		}
		this.tamanio = tamanio;
	}

	public float getTamanio() {
		return tamanio;
	}
	private boolean validarTamanio(float tamanio) {
		return tamanio>=0;
	}
}
