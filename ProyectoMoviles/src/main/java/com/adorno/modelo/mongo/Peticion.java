package com.adorno.modelo.mongo;

import java.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public abstract class Peticion {

	@Id
	private Long id;

	private Long id_user;
	private Long id_peticion;
	private String oferta;

	private LocalDate fecha_creacion;
	//@DBRef(lazy = true) // esto es para la bidireccionalidad
	//private List<User> usuarios;
	
	
}
