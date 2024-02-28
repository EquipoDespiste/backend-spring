package com.adorno.modelo.mongo;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PeticionIntercambio")
public class PeticionIntercambio extends Peticion {
	private Long idAnuncioInteresado;

	public PeticionIntercambio(Long id_user, ObjectId id_peticion, String oferta, LocalDate fecha_creacion, Long idAnuncioInteresado) {
		super(id_user, id_peticion, oferta, fecha_creacion);
		this.idAnuncioInteresado=idAnuncioInteresado;
	}
	
	

}
