package com.adorno.filtros;

import com.adorno.criterio.Criterio;
import com.adorno.modelo.Movil;

public class FiltroPrecio implements Filtro<Movil> {

	private Criterio<Float> criterio;
	
	public FiltroPrecio(Criterio<Float> criterio) {
		super();
		this.criterio = criterio;
	}

	@Override
	public boolean filter(Movil t) {
		return this.criterio.passCriterio(t.getPrecio_actual());
	}

}
