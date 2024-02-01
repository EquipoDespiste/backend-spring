package com.adorno.filtros;

import com.adorno.criterio.Criterio;
import com.adorno.modelo.Movil;

public class FiltroRam implements Filtro<Movil> {
	
	private Criterio<Integer> criterio;
	
	public FiltroRam(Criterio criterio) {
		super();
		this.criterio = criterio;
	}

	@Override
	public boolean filter(Movil t) {
		
		return this.criterio.passCriterio(t.getRam());
	}

}
