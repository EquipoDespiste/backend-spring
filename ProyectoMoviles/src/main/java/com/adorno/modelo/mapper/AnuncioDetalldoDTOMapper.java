package com.adorno.modelo.mapper;

import com.adorno.modelo.dto.AnuncioDetalladoDTO;
import com.adorno.modelo.mongo.Anuncio;

public class AnuncioDetalldoDTOMapper implements IMapper<AnuncioDetalladoDTO, Anuncio>{

	@Override
	public AnuncioDetalladoDTO mapToDTO(Anuncio k) {
		
		return new AnuncioDetalladoDTO(
				k.getIdMovil(),
				k.getDescripcion(),
				k.getEstado(),
				k.getTipoAnuncio()
				);
	}

	@Override
	public Anuncio mapToEntity(AnuncioDetalladoDTO t) {
		// TODO Auto-generated method stub
		return null;
	}





}
