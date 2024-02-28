package com.adorno.modelo.dto;

import com.adorno.modelo.mongo.EstadoMovil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnuncioDetalladoDTO {

	private Long idMovil;
	private String descripcion;
	
	private EstadoMovil estado;
	private String tipoAnuncio;
}
