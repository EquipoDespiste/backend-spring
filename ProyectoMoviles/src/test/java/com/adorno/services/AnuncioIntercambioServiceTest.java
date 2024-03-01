package com.adorno.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.adorno.modelo.mongo.AnuncioIntercambio;
import com.adorno.modelo.mongo.EstadoMovil;
import com.adorno.modelo.mongo.PeticionIntercambio;
import com.adorno.repositorio.UserRepository;

@SpringBootTest
class AnuncioIntercambioServiceTest {

	@Autowired
	AnuncioIntercambioService anuncioIntercambioService;
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Test
	void test() {
		mongoTemplate.getCollection("AnuncioIntercambio").drop();
		assertTrue(anuncioIntercambioService.add(new AnuncioIntercambio(1l, "hola", "Rangel", EstadoMovil.intacto, "intercambio", 95f, new ArrayList<PeticionIntercambio>())));
	}
	@Test	
	void testFindAllByUsername() {
		mongoTemplate.getCollection("AnuncioIntercambio").drop();
		AnuncioIntercambio anuncio = new AnuncioIntercambio(1l, "hola", "Rangel", EstadoMovil.intacto, "intercambio", 95f, new ArrayList<PeticionIntercambio>());
		assertTrue(anuncioIntercambioService.add(anuncio));
		AnuncioIntercambio anuncio1 = new AnuncioIntercambio(2l, "hola", "Rangel", EstadoMovil.intacto, "intercambio", 100f, new ArrayList<PeticionIntercambio>());
		assertTrue(anuncioIntercambioService.add(anuncio1));
		
		List<AnuncioIntercambio> anuncios = new ArrayList<>();
		anuncios = anuncioIntercambioService.getAllByUsername("Rangel");
		System.out.println(anuncios.get(0).toString());
		assertEquals(anuncio, anuncios.get(0));
		assertNotNull(anuncios.get(1));
	
	}

}
