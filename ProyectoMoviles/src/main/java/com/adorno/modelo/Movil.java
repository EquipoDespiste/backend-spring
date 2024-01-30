package com.adorno.modelo;

import org.hibernate.validator.constraints.Length;

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
	@Min(value=1)
	@NotNull
	private Long id;
	@NotBlank
	@NotNull
	@Pattern(regexp = "[a-zA-Z0-9]", message = "El campo debe contener solamente letras y/o numeros")
	@Size(min=3, max=60, message = "No cumple con la longitud requerida")
	private String modelo;
	@NotEmpty
	@Min(value=1)
	private int almacenamiento_gb;
	@NotEmpty
	@Min(value=1)
	@Max(value = 64)
	@Positive
	private int ram;
	@NotEmpty
	@Positive
	@DecimalMax(value = "999.99", inclusive = true)
	private float peso;
	@NotEmpty
	private int camara;
	@NotEmpty
	private int bateria;
	@NotNull
	private boolean nfc;
	@Positive
	private int contador_visita;
	@Positive
	private float precio_actual;
	
	
	@ManyToOne
	@NotNull
	private Marca marca;
	@ManyToOne
	private Pantalla pantalla;
	@ManyToOne
	private Dimension dimension;
	@ManyToOne
	private Procesador procesador;
	
	public Movil(String modelo, int almacenamiento_gb, int ram, float peso, int camara, int bateria,
			boolean nfc, int contador_visita, float precio_actual) {
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

	
	
}
