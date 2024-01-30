package com.adorno.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovilRequest {
	private String marca;
	private float precioMin;
	private float precioMax;
	private int ramMin;
	private int ramMax;
	private boolean nfc;
	private String tecnologiaPantalla;
	
}
