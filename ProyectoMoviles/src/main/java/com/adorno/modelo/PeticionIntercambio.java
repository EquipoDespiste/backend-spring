package com.adorno.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeticionIntercambio extends Peticion{
private Long idUsuarioInteresado;
private Long idAnuncioInteresado;
}
