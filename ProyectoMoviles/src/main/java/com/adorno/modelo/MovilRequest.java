package com.adorno.modelo;

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
	@Min(value=1)
	@Positive
	private float precioMin;
	@Max(value = 99999)
	@Positive
	private float precioMax;
	@Min(value=1)
	@Positive
	private int ramMin;
	@Max(value = 99999)
	@Positive
	private int ramMax;
	
	private boolean nfc;
	private String tecnologiaPantalla;
	
	
	
	public MovilRequest(String marca, @Min(1) @Positive @DefaultValue(value = "1") float precioMin, @Max(99999) @Positive @DefaultValue(value = "999999.99") float precioMax, int ramMin, int ramMax,
			boolean nfc, String tecnologiaPantalla) {
		super();
		this.marca = marca;
		this.precioMin = precioMin;
		this.precioMax = precioMax;
		this.ramMin = ramMin;
		this.ramMax = ramMax;
		this.nfc = nfc;
		this.tecnologiaPantalla = tecnologiaPantalla;
	}
}
