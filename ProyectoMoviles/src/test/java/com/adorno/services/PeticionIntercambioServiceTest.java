package com.adorno.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.adorno.modelo.mongo.AnuncioIntercambio;
import com.adorno.modelo.mongo.EstadoMovil;
import com.adorno.modelo.mongo.PeticionIntercambio;

@SpringBootTest
public class PeticionIntercambioServiceTest {


	@Autowired
	PeticionIntercambioService peticionIntercambioService;
	
	@Autowired
	AnuncioIntercambioService anuncioIntercambioService;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Test
	void test() {
		
		
		String id = "65e1a20e0e695b1938a73c23";
		ObjectId idObj = new ObjectId(id);
		
		mongoTemplate.getCollection("PeticionIntercambio").drop();
		AnuncioIntercambio anuncio = new AnuncioIntercambio(1l, "hola", "Rangel", EstadoMovil.intacto, "intercambio", 95f, new ArrayList<PeticionIntercambio>());
		anuncioIntercambioService.add(anuncio);
		anuncio = anuncioIntercambioService.findAll().get(0);
		assertTrue(peticionIntercambioService.add(new PeticionIntercambio("username",idObj, "intercambio",LocalDate.now(), anuncio)));
	}

}
