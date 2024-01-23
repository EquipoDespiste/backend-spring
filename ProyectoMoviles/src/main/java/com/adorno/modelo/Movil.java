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
	
//	esto esta comentado porque aun no sabemos como hacer localdate para postman
//	private LocalDate fecha_lanzamiento;
	
	//He hecho estos gets para comprobar, ya que a mi no me va lombok aun :(
	public long getId() {

		return this.id;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}

	public int getAlmacenamiento_gb() {
		return almacenamiento_gb;
	}

	public int getRam() {
		return ram;
	}

	public float getPeso() {
		return peso;
	}

	public int getCamara() {
		return camara;
	}

	public int getBateria() {
		return bateria;
	}

	public boolean isNfc() {
		return nfc;
	}

	public int getContador_visita() {
		return contador_visita;
	}

	public float getPrecio_actual() {
		return precio_actual;
	}

//	public LocalDate getFecha_lanzamiento() {
//		return fecha_lanzamiento;
//	}
//	
}
