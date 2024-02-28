package com.adorno.modelo.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PeticionIntercambio")
public class PeticionIntercambio extends Peticion{
private Long idAnuncioInteresado;

}
