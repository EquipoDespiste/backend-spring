package com.adorno.modelo.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "PeticionVenta")
public class PeticionVenta extends Peticion{
private Float precioPropuesto;
}
