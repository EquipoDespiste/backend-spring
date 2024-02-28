package com.adorno.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeticionVenta extends Peticion{
private Long idUsuarioInteresado;

}
