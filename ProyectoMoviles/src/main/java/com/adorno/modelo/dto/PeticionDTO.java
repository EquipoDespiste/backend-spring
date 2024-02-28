package com.adorno.modelo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeticionDTO {

	private Long id_user;
	private Long id_peticion;
	private String oferta;
	private LocalDate fecha_creacion;
	
}
