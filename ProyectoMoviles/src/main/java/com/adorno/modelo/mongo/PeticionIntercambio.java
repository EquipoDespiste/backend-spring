package com.adorno.modelo.mongo;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PeticionIntercambio")
public class PeticionIntercambio extends Peticion {
	@DBRef
	private AnuncioIntercambio idAnuncioInteresado;

	public PeticionIntercambio(String username, ObjectId id_peticion, String oferta, LocalDate fecha_creacion, AnuncioIntercambio idAnuncioInteresado) {
		super(username, id_peticion, oferta, fecha_creacion);
		this.idAnuncioInteresado=idAnuncioInteresado;
	}
	
	
	
	

}
