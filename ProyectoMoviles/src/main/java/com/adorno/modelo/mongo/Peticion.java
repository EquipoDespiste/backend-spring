package com.adorno.modelo.mongo;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.adorno.modelo.sqlSecurity.UserEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public abstract class Peticion {

	@Id
	private ObjectId id;
	/*
	 * no sabemos aun si el user se guardara en mongo o en h2 por lo que 
	 * quedamos este id asi
	 */
	private Long id_user;
	/*
	 * será una ref a la Peticion.
	 */
	private ObjectId referencia;
	private String oferta;

	private LocalDate fecha_creacion;
	 @DBRef(lazy = true) // esto es para la bidireccionalidad
	 private List<UserEntity> usuarios;

	public Peticion(Long id_user, ObjectId referencia, String oferta, LocalDate fecha_creacion) {
		super();
		this.id_user = id_user;
		this.referencia = referencia;
		this.oferta = oferta;
		this.fecha_creacion = fecha_creacion;
	}

}
