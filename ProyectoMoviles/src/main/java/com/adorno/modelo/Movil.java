package com.adorno.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Id
	private String modelo;
	private String marca;
	private int almacenamiento_gb;
	private int ram;
	private float peso;
	private int camara;
	private int bateria;
	private boolean nfc;
	private int contador_visita;
	private float precio_actual;
	private LocalDate fecha_lanzamiento;
	
}
