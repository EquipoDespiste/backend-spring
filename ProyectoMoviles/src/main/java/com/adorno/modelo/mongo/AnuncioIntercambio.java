package com.adorno.modelo.mongo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "AnuncioIntercambio")
public class AnuncioIntercambio extends Anuncio {
	private Float vidaBateria;
	private List<PeticionIntercambio> peticiones;
	
	
	public AnuncioIntercambio(Long idMovil, String descripcion, EstadoMovil estado, String tipoAnuncio,Float vidaBateria, List<PeticionIntercambio> peticiones) {
		super(idMovil, descripcion, estado, tipoAnuncio);
		this.vidaBateria=vidaBateria;
		this.peticiones=peticiones;
	}
	
	
}
