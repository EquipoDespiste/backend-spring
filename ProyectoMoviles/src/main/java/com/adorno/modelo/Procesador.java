package com.adorno.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Min(value = 1)
	
	private Long id;
	@Size(min = 10, max = 75)
	@NotBlank
	@NotNull
	//@Pattern(regexp = "[a-zA-Z0-9]", message = "Este campo solo debe contener letras y/o numeros")
	private String tipo;
	@NotNull
	@Min(value = 1)
	@Max(value = 32)
	@Positive
	private int nucleos;
	@NotNull
	@Positive
	@DecimalMax(value = "4.9", inclusive = true)
	private float velocidad_max;
	public Procesador(@Size(min = 10, max = 75) @NotBlank @NotNull String tipo,
			@NotNull @Min(1) @Max(32) @Positive int nucleos,
			@NotNull @Positive @DecimalMax(value = "4.9", inclusive = true) float velocidad_max) {
		super();
		this.tipo = tipo;
		this.nucleos = nucleos;
		this.velocidad_max = velocidad_max;
	}
	
	

	

}
