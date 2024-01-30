package com.adorno.modelo;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Digits;
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
public class Movil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Min(value = 1)
	private Long id;
	@NotBlank
	@NotNull
//	@Pattern(regexp = "/^[A-Za-z0-9]$/", message = "El campo debe contener solamente letras y/o numeros")
	@Size(min = 3, max = 60, message = "No cumple con la longitud requerida")
	private String modelo;
	@NotNull
	@Min(value = 1)
	private int almacenamiento_gb;
	@NotNull
	@Min(value = 1)
	@Max(value = 64)
	@Positive
	private int ram;
	@NotNull
	@Positive
	@Min(value = 1)
	@DecimalMax(value = "999.99", inclusive = true)
	private float peso;
	@NotNull
	@Min(value = 1)
	private int camara;
	@NotNull
	@Min(value = 1)
	private int bateria;
	@NotNull
	private boolean nfc;
	@Positive
	private int contador_visita;
	@Positive
	private float precio_actual;

	@ManyToOne(cascade = CascadeType.ALL)
	private Marca marca;
	@ManyToOne(cascade = CascadeType.ALL)
	private Pantalla pantalla;
	@ManyToOne(cascade = CascadeType.ALL)
	private Dimension dimension;
	@ManyToOne(cascade = CascadeType.ALL)
	private Procesador procesador;

	public Movil(String modelo, int almacenamiento_gb, int ram, float peso, int camara, int bateria, boolean nfc,
			int contador_visita, float precio_actual, Marca marca, Pantalla pantalla, Dimension dimension,
			Procesador procesador) {
		super();
		this.modelo = modelo;
		this.almacenamiento_gb = almacenamiento_gb;
		this.ram = ram;
		this.peso = peso;
		this.camara = camara;
		this.bateria = bateria;
		this.nfc = nfc;
		this.contador_visita = contador_visita;
		this.precio_actual = precio_actual;
		this.marca = marca;
		this.pantalla = pantalla;
		this.dimension = dimension;
		this.procesador = procesador;
	}

	public String getTecnologiaPantalla() {
		return pantalla.getTecnologia();
	}

	public Movil(
			@NotBlank @NotNull /*
								 * @Pattern(regexp = "/^[A-Za-z0-9]$/", message =
								 * "El campo debe contener solamente letras y/o numeros")
								 */ @Size(min = 3, max = 60, message = "No cumple con la longitud requerida") String modelo,
			@NotNull @Min(1) int almacenamiento_gb, @NotNull @Min(1) @Max(64) @Positive int ram,
			@NotNull @Positive @Min(1) @DecimalMax(value = "999.99", inclusive = true) float peso,
			@NotNull @Min(1) int camara, @NotNull @Min(1) int bateria, @NotNull boolean nfc,
			@Positive int contador_visita, @Positive float precio_actual) {
		super();
		this.modelo = modelo;
		this.almacenamiento_gb = almacenamiento_gb;
		this.ram = ram;
		this.peso = peso;
		this.camara = camara;
		this.bateria = bateria;
		this.nfc = nfc;
		this.contador_visita = contador_visita;
		this.precio_actual = precio_actual;
	}

	public Movil(
			@NotBlank @NotNull @Size(min = 3, max = 60, message = "No cumple con la longitud requerida") String modelo,
			@NotNull @Min(1) int almacenamiento_gb, @NotNull @Min(1) @Max(64) @Positive int ram,
			@NotNull @Positive @Min(1) @DecimalMax(value = "999.99", inclusive = true) float peso,
			@NotNull @Min(1) int camara, @NotNull @Min(1) int bateria, @NotNull boolean nfc,
			@Positive int contador_visita, @Positive float precio_actual, Marca marca) {
		super();
		this.modelo = modelo;
		this.almacenamiento_gb = almacenamiento_gb;
		this.ram = ram;
		this.peso = peso;
		this.camara = camara;
		this.bateria = bateria;
		this.nfc = nfc;
		this.contador_visita = contador_visita;
		this.precio_actual = precio_actual;
		this.marca = marca;
	}

}
