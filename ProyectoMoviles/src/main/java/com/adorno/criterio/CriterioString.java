package com.adorno.criterio;

public class CriterioString implements Criterio<String> {

	private String cadena;
	
	public CriterioString(String cadena) {
		super();
		this.cadena = cadena;
	}

	@Override
	public boolean passCriterio(String k) {
		
		return this.cadena.equalsIgnoreCase(k);
	}

}
