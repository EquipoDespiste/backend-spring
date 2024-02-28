package com.adorno.filtros;

import com.adorno.criterio.Criterio;
import com.adorno.modelo.sql.Movil;

public class FiltroMarca implements Filtro<Movil> {
	private Criterio<String> criterio;
	
	public FiltroMarca(Criterio<String> criterio) {
		super();
		this.criterio = criterio;
	}

	@Override
	public boolean filter(Movil t) {
		return this.criterio.passCriterio(t.getNombreMarca());
	}

}
