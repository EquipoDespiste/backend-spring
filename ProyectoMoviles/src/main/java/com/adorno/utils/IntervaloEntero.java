package com.adorno.utils;

import com.adorno.varglobales.VarGlobal;

public class IntervaloEntero {
	
	private int min;
	private int max;
	public IntervaloEntero(Integer min, Integer max) {
		super();
		if(min == null )
			min = VarGlobal.RAM_MIN_DEFAULT;
		if(max == null)
			max = VarGlobal.RAM_MAX_DEFAULT;
		this.min = min;
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
	

}
