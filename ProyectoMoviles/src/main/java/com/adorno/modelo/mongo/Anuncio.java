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
	private String username;
	private EstadoAnuncio estadoAnuncio;
	// ESTO ES PROVISIONAL
	private EstadoMovil estado;
	private String tipoAnuncio;
	public Anuncio(Long idMovil, String descripcion, EstadoMovil estado, String tipoAnuncio) {
		super();
		this.idMovil = idMovil;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tipoAnuncio = tipoAnuncio;
	}
	
	
	
}
