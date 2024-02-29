package com.adorno.repositorio;


import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.adorno.modelo.mongo.AnuncioIntercambio;
import com.adorno.modelo.mongo.EstadoMovil;
import com.adorno.modelo.mongo.PeticionIntercambio;

@SpringBootTest
class IPeticionIntercambioRepositorioTest {
	
	@Autowired
	IPeticionIntercambioRepositorio peticionIntercambioRepo;
	@Autowired
	IAnuncioIntercambioRepositorio anuncioIntercambioRepositorio;
	

	
	@Autowired
	MongoTemplate mongoTemplate;

	@Test
	void test() {
		
	//IMPORTANTE
	mongoTemplate.getCollection("PeticionIntercambio").drop();
	
	//SE NNECESITA GUARDAR EN LA BASE DE DATOS EL ANUNCIO PARA QUE SE GENERE UN ID, SINO NO SE GENERA
	anuncioIntercambioRepositorio.save(new AnuncioIntercambio(1l, "hola", EstadoMovil.intacto, "intercambio", 95f, new ArrayList<PeticionIntercambio>()));
	AnuncioIntercambio anuncio = anuncioIntercambioRepositorio.findAll().get(0);

	PeticionIntercambio peticion = new PeticionIntercambio(1l, anuncio.getId(), "oferta", LocalDate.now(), anuncio.getId());
	
	peticionIntercambioRepo.save(peticion);
	
	
	}

}
