package com.adorno.modelo;

import com.adorno.modelo.valuesObject.NombreTecnologia;
import com.adorno.modelo.valuesObject.TamanioDimension;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pantalla {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private TamanioDimension tamanio;
	private NombreTecnologia tecnologia;
	
	
	public Pantalla(float tamanio, String tecnologia) {
		super();
		this.tamanio = new TamanioDimension(tamanio);
		this.tecnologia = new NombreTecnologia(tecnologia);
	}


	public Pantalla(long id, float tamanio, String tecnologia) {
		this.id=id;
		this.tamanio = new TamanioDimension(tamanio);
		this.tecnologia = new NombreTecnologia(tecnologia);
	}

	public float getTamanio() {
		return tamanio.getTamanio();
	}


	public void setTamanio(float tamanio) {
		this.tamanio =  new TamanioDimension(tamanio);;
	}


	public String getTecnologia() {
		return tecnologia.getTecnologia();
	}


	public void setTecnologia(String tecnologia) {
		this.tecnologia = new NombreTecnologia(tecnologia);
	}


	public Long getId() {
		return id;
	}



	
	

}
