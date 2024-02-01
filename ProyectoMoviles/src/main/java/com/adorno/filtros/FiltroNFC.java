package com.adorno.filtros;

import com.adorno.criterio.Criterio;
import com.adorno.modelo.Movil;

public class FiltroNFC implements Filtro<Movil> {

	private Criterio<Boolean> criterio;

	public FiltroNFC(Criterio<Boolean> criterio) {

		this.criterio = criterio;

	}

	@Override
	public boolean filter(Movil t) {

		return criterio.passCriterio(t.isNfc());
	}

}
