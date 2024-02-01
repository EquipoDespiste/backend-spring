package com.adorno.criterio;

import com.adorno.utils.IntervaloEntero;

public class CriterioIntervaloEntero extends IntervaloEntero implements Criterio<Integer> {

	public CriterioIntervaloEntero(Integer min, Integer max) {
		super(min, max);
	}

	@Override
	public boolean passCriterio(Integer k) {
		return k >= getMin() && k <= getMax();
	}

	
}
