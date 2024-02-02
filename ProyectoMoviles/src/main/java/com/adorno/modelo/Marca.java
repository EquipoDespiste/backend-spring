package com.adorno.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Min(value = 1)

	private Long id;

	@NotNull
//	@Column(unique = true)
	private String nombre;

	public Marca(String nombre) {
		super();
		this.nombre = nombre;
	}

}
