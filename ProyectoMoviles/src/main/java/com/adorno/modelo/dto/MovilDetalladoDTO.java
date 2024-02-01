package com.adorno.modelo.dto;

import com.adorno.modelo.Dimension;
import com.adorno.modelo.Pantalla;
import com.adorno.modelo.Procesador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovilDetalladoDTO {

	private String modelo;
	private int almacenamiento_gb;
	private int ram;
	private float peso;
	private int camara;
	private int bateria;
	private boolean nfc;
	private float precio_actual;
	
	private String marca;
	private Pantalla pantalla;
	private Dimension dimension;
	private Procesador procesador;
	
}
