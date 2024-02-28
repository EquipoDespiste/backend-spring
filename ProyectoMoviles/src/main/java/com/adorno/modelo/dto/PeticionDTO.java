package com.adorno.modelo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PeticionDTO {

	private Long id;
	private Long id_user;
	private Long id_anuncio;
	private String oferta;
	private LocalDate fecha_creacion;
	
}
