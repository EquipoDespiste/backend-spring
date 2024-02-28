package com.adorno.modelo.dto;

import org.bson.types.ObjectId;

import com.adorno.modelo.mongo.EstadoMovil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnuncioResumenDTO {

	private ObjectId id;
	private Long idMovil;
	private EstadoMovil estado;
	private String tipoAnuncio;
	
	// falta el estado del anuncio
}
