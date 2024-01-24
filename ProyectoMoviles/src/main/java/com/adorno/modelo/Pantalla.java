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

	
	
	public Pantalla(float tamanio, String tecnologia) {
		super();
		this.tamanio = tamanio;
		this.tecnologia = tecnologia;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float tamanio;
	private String tecnologia;
	
	

}
