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
public class Dimension {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float alto;
	private float ancho;
	private float grosor;
	
	
	public Long getId() {
		return id;
	}
	public float getAlto() {
		return alto;
	}
	public float getAncho() {
		return ancho;
	}
	public float getGrosor() {
		return grosor;
	}
	
	

}
