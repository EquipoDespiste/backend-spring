package com.adorno.modelo.mapper;

import com.adorno.modelo.Movil;
import com.adorno.modelo.dto.MovilDetalladoDTO;

public class MovilDetalladoDTOMapper implements IMapper<MovilDetalladoDTO, Movil> {

	
	@Override
	public MovilDetalladoDTO mapToDTO(Movil k) {
		return new MovilDetalladoDTO( k.getModelo(),
									k.getAlmacenamiento_gb(),
									k.getRam(),
									k.getPeso(),
									k.getCamara(),
									k.getBateria(),
									k.isNfc(),
									k.getPrecio_actual(),
									k.getNombreMarca(),
									k.getPantalla(),
									k.getDimension(),
									k.getProcesador());
	}

	@Override
	public Movil mapToEntity(MovilDetalladoDTO t) {
		// TODO 
		return null;
	}
	
	
}
