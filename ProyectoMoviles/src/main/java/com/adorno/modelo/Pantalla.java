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
public class Pantalla {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float tamanio;
	
	
	public Long getId() {
		return id;
	}


	public float getTamanio() {
		return tamanio;
	}


	public String getTecnologia() {
		return tecnologia;
	}


	private String tecnologia;
}
