package com.adorno.filtros;

import com.adorno.criterio.Criterio;
import com.adorno.modelo.Movil;

public class FiltroPantallaTech implements Filtro<Movil>{

	private Criterio<String> criterio;
	
	public FiltroPantallaTech(Criterio<String> criterio) {
		super();
		this.criterio = criterio;
	}

	@Override
	public boolean filter(Movil t) {
		return this.criterio.passCriterio(t.getTecnologiaPantalla());
	}

}
