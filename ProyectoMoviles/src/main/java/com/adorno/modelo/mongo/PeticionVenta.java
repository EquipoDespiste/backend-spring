package com.adorno.modelo.mongo;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "PeticionVenta")
public class PeticionVenta extends Peticion {
	private Float precioPropuesto;
	@DBRef
	private AnuncioVenta idAnuncioInteresado;

	public PeticionVenta(String username, ObjectId id_peticion, String oferta, LocalDate fecha_creacion, Float precioPropuesto, AnuncioVenta idAnuncioInteresado) {
		super(username, id_peticion, oferta, fecha_creacion);
		this.precioPropuesto=precioPropuesto;
		this.idAnuncioInteresado=idAnuncioInteresado;
	}
	
	
}
