package com.adorno.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnuncioVenta extends Anuncio{
private Long idPeticionVenta;
private Float precio;
//TODO peticionVenta
}
