package com.adorno.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	private String modelo;
	private int almacenamiento_gb;
	private int ram;
	private float peso;
	private int camara;
	private int bateria;
	private boolean nfc;
	private int contador_visita;
	private float precio_actual;
	@ManyToOne
	private Marca marca;
	@ManyToOne
	private Pantalla pantalla;
	@ManyToOne
	private Dimension dimension;
	@ManyToOne
	private Procesador procesador;
	
	public Movil(String modelo, int almacenamiento_gb, int ram, float peso, int camara, int bateria,
			boolean nfc, int contador_visita, float precio_actual) {
		super();
		this.modelo = modelo;
		this.almacenamiento_gb = almacenamiento_gb;
		this.ram = ram;
		this.peso = peso;
		this.camara = camara;
		this.bateria = bateria;
		this.nfc = nfc;
		this.contador_visita = contador_visita;
		this.precio_actual = precio_actual;
	}

	public Movil(String modelo, int almacenamiento_gb, int ram, float peso, int camara, int bateria, boolean nfc,
			int contador_visita, float precio_actual, Marca marca, Pantalla pantalla, Dimension dimension,
			Procesador procesador) {
		super();
		this.modelo = modelo;
		this.almacenamiento_gb = almacenamiento_gb;
		this.ram = ram;
		this.peso = peso;
		this.camara = camara;
		this.bateria = bateria;
		this.nfc = nfc;
		this.contador_visita = contador_visita;
		this.precio_actual = precio_actual;
		this.marca = marca;
		this.pantalla = pantalla;
		this.dimension = dimension;
		this.procesador = procesador;
	}

	
	
	
}
