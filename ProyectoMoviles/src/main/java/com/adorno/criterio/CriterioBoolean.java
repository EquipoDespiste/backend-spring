package com.adorno.criterio;

public class CriterioBoolean implements Criterio<Boolean> {

	Boolean criterio;

	public CriterioBoolean(Boolean criterio) {
		if(criterio==null)
			this.criterio=true;
		else
			this.criterio = criterio;
	}

	@Override
	public boolean passCriterio(Boolean valorDelMovil) {
		return valorDelMovil == criterio;
	}

}
