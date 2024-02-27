package com.adorno.modelo.mapper;

import com.adorno.modelo.Peticion;
import com.adorno.modelo.dto.PeticionDTO;


public class PeticionDTOMapper implements IMapper<PeticionDTO, Peticion> {@Override
	
	
	public PeticionDTO mapToDTO(Peticion k) {
		
		return new PeticionDTO().builder()
				.id_user(k.getId_user())
				.id_anuncio(k.getId_anuncio())
				.oferta(k.getOferta())
				.fecha_creacion(k.getFecha_creacion())
				.build();
	}

	@Override
	public Peticion mapToEntity(PeticionDTO t) {
		// TODO Auto-generated method stub
		return null;
	}


}
