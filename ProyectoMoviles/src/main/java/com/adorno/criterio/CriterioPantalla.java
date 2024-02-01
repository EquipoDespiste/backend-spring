package com.adorno.criterio;

import com.adorno.varglobales.VarGlobal;

public class CriterioPantalla implements Criterio<String> {

	private String cadena;
	
	public CriterioPantalla(String cadena) {
		super();
		if(cadena==null) {
			this.cadena=VarGlobal.PANTALLA_DEFAULT;
		}else {			
			this.cadena = cadena;
		}
	}

	@Override
	public boolean passCriterio(String k) {
		if(this.cadena.equals(VarGlobal.PANTALLA_DEFAULT))
			return true;
		return this.cadena.equalsIgnoreCase(k);
	}

}
