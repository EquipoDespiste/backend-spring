package com.adorno.modelo;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "peticiones")
public abstract class Peticion {

	@Id
	private Long id;

	private Long id_user;
	private Long id_peticion;
	private String oferta;

	private LocalDate fecha_creacion;
}
