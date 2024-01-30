package com.adorno.modelo.mapper;

import com.adorno.modelo.Movil;
import com.adorno.modelo.dto.MovilResumenDTO;

public class MovilResumenDTOMapper implements IMapper<MovilResumenDTO, Movil> {

	
	@Override
	public MovilResumenDTO mapToDTO(Movil k) {
		
		return new MovilResumenDTO( k.getModelo(),
									k.getMarca().getNombre(),
									k.getProcesador().getNucleos(),
									k.getAlmacenamiento_gb(),
									k.getRam(),
									k.getPrecio_actual());
	}

	@Override
	public Movil mapToEntity(MovilResumenDTO t) {
		// TODO 
		return null;
	}
	
	
}
