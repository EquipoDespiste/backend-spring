package com.adorno.modelo.mongo;

import com.adorno.modelo.Peticion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeticionVenta extends Peticion{
private Float precioPropuesto;
}
