package com.adorno.modelo.mapper;

import com.adorno.modelo.dto.PeticionDTO;
import com.adorno.modelo.mongo.Peticion;

public class PeticionDTOMapper implements IMapper<PeticionDTO, Peticion>{

	@Override
	public PeticionDTO mapToDTO(Peticion k) {
	
		return PeticionDTO.builder()
				.id_user(k.getId_user())
				.id_peticion(k.getReferencia())
				.oferta(k.getOferta())
				.fecha_creacion(k.getFecha_creacion())
				.build();
	}

	@Override
	public Peticion mapToEntity(PeticionDTO t) {
		return null;
	}

}
