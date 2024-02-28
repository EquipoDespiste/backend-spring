package com.adorno.modelo.mongo;

import java.time.LocalDate;

import org.bson.types.ObjectId;
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

	public PeticionVenta(Long id_user, ObjectId id_peticion, String oferta, LocalDate fecha_creacion, Float precioPropuesto) {
		super(id_user, id_peticion, oferta, fecha_creacion);
		this.precioPropuesto=precioPropuesto;
	}
	
	
}
