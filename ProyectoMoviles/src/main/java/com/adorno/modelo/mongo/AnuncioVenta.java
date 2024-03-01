package com.adorno.modelo.mongo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "AnuncioVenta")
public class AnuncioVenta extends Anuncio {
	private Float precio;
	private List<PeticionVenta> listaPeticionVenta;

	public AnuncioVenta(Long idMovil, String descripcion, String username, EstadoMovil estado, String tipoAnuncio,
			Float precio, List<PeticionVenta> listaPeticionVenta) {
		super(idMovil, descripcion, username, estado, tipoAnuncio);
		this.precio = precio;
		this.listaPeticionVenta = listaPeticionVenta;
	}
	
	public boolean addPeticion(PeticionVenta p) {
		return listaPeticionVenta.add(p);
	}

}
