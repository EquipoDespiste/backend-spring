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
	@NotNull
	private Long id;
	@Size(min = 10, max = 75)
	@NotBlank
	@NotNull
	@Pattern(regexp = "[a-zA-Z0-9]", message = "Este campo solo debe contener letras y/o numeros")
	private String tipo;
	@NotEmpty
	@Min(value = 1)
	@Max(value = 32)
	@Positive
	private int nucleos;
	@NotEmpty
	@Positive
	@DecimalMax(value = "4.9", inclusive = true)
	private float velocidad_max;
	
	public Procesador(String tipo, int nucleos, float velocidad_max) {
		super();
		this.tipo = tipo;
		this.nucleos = nucleos;
		this.velocidad_max = velocidad_max;
	}

}
