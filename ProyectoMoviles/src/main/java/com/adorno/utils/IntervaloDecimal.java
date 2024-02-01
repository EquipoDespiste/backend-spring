package com.adorno.utils;

import com.adorno.varglobales.VarGlobal;

public class IntervaloDecimal {
	
	private Float minimo;
	private Float maximo;
	
	public IntervaloDecimal(Float minimo, Float maximo) {
		super();
		
		if(minimo== null)
			minimo= VarGlobal.PRECIO_MIN_DEFAULT;
		if(maximo==null)
			maximo = VarGlobal.PRECIO_MAX_DEFAULT;
		this.minimo = minimo;
		this.maximo = maximo;
	}

	public IntervaloDecimal(IntervaloDecimal intervalo) {
		this.maximo = intervalo.getMaximo();
		this.minimo = intervalo.getMinimo();
	}

	public Float getMinimo() {
		return minimo;
	}

	public void setMinimo(Float minimo) {
		this.minimo = minimo;
	}

	public Float getMaximo() {
		return maximo;
	}

	public void setMaximo(Float maximo) {
		this.maximo = maximo;
	}
	
	
}
