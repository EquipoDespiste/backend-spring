package com.adorno.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnuncioCambio  extends Anuncio{
	private Long idPeticionVenta;
	//TODO peticionCambio
}
