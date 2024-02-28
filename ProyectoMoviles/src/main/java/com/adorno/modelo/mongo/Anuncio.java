package com.adorno.modelo.mongo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Anuncio {
	@Id
	private ObjectId id;
	private Long idMovil;
	private String descripcion;
	
	// ESTO ES PROVISIONAL
	private EstadoMovil estado;
	private String tipoAnuncio;
	
}
