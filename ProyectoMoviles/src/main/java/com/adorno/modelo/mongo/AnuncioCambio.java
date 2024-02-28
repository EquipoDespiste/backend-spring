package com.adorno.modelo.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnuncioCambio extends Anuncio{
private Float vidaBateria;
}
