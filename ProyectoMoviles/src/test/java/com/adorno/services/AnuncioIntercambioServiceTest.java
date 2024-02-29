package com.adorno.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.adorno.modelo.mongo.AnuncioIntercambio;
import com.adorno.modelo.mongo.EstadoMovil;
import com.adorno.modelo.mongo.PeticionIntercambio;

@SpringBootTest
class AnuncioIntercambioServiceTest {

	@Autowired
	AnuncioIntercambioService anuncioIntercambioService;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Test
	void test() {
		mongoTemplate.getCollection("AnuncioIntercambio").drop();
		assertTrue(anuncioIntercambioService.add(new AnuncioIntercambio(1l, "hola", EstadoMovil.intacto, "intercambio", 95f, new ArrayList<PeticionIntercambio>())));
	}

}
