package com.adorno.modelo;

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
public class Procesador {

	
	public Procesador(String tipo, int nucleos, float velocidad_max) {
		super();
		this.tipo = tipo;
		this.nucleos = nucleos;
		this.velocidad_max = velocidad_max;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	private int nucleos;
	private float velocidad_max;
}
