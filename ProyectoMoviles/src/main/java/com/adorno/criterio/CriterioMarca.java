package com.adorno.criterio;

public class CriterioMarca implements Criterio<String> {

	private String marca;
	
	public CriterioMarca(String marca) {
		super();
		if(marca==null)
			this.marca="";
		else
			this.marca =marca;
			
	}

	@Override
	public boolean passCriterio(String k) {
		return this.marca.equals(k);
	}

}
