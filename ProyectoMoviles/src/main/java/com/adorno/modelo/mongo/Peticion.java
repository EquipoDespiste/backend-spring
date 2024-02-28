package com.adorno.modelo.mongo;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public abstract class Peticion {

	@Id
	private ObjectId id;

	private Long id_user;
	private Long id_peticion;
	private String oferta;

	private LocalDate fecha_creacion;
	//@DBRef(lazy = true) // esto es para la bidireccionalidad
	//private List<User> usuarios;

	public Peticion(Long id_user, Long id_peticion, String oferta, LocalDate fecha_creacion) {
		super();
		this.id_user = id_user;
		this.id_peticion = id_peticion;
		this.oferta = oferta;
		this.fecha_creacion = fecha_creacion;
	}
	
	
	
	
}
