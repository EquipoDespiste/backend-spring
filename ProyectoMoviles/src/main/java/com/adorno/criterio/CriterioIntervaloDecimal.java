package com.adorno.criterio;

import com.adorno.utils.IntervaloDecimal;

public class CriterioIntervaloDecimal extends IntervaloDecimal implements Criterio<Float>{
	
	public CriterioIntervaloDecimal(IntervaloDecimal intervalo) {
		super(intervalo);
	}
	public CriterioIntervaloDecimal(Float min, Float max) {
		super(min, max);
	}

	@Override
	public boolean passCriterio(Float k) {
		
		return k >= getMinimo() && k<= getMaximo();
	}
	
}
