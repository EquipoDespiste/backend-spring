package com.adorno.modelo.sql;

import org.springframework.boot.context.properties.bind.DefaultValue;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class MovilRequest {
	
	
	private String marca;
	private Float precioMin;
	private Float precioMax;
	private Integer ramMin;
	private Integer ramMax;
	private Boolean nfc;
	private String tecnologiaPantalla;

	public MovilRequest(String marca, Float precioMin, Float precioMax, Integer ramMin, Integer ramMax,
			Boolean nfc, String tecnologiaPantalla) {
		super();
		this.marca = marca;
		this.precioMin = precioMin;
		this.precioMax = precioMax;
		this.ramMin = ramMin;
		this.ramMax = ramMax;
		this.nfc = nfc;
		this.tecnologiaPantalla = tecnologiaPantalla;
	}

	@Override
	public String toString() {
		return "MovilRequest [marca=" + marca + ", precioMin=" + precioMin + ", precioMax=" + precioMax + ", ramMin="
				+ ramMin + ", ramMax=" + ramMax + ", nfc=" + nfc + ", tecnologiaPantalla=" + tecnologiaPantalla + "]";
	}
}
