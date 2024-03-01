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

import com.adorno.modelo.mongo.AnuncioVenta;
import com.adorno.modelo.mongo.EstadoMovil;
import com.adorno.modelo.mongo.PeticionVenta;
import com.adorno.repositorio.UserRepository;

@SpringBootTest
class AnuncioVentaServiceTest {

	@Autowired
	AnuncioVentaService anuncioVentaService;
	@Autowired
	UserRepository userRepo;

	@Autowired
	MongoTemplate mongoTemplate;

	@Test
	void test() {
		mongoTemplate.getCollection("AnuncioVenta").drop();
		assertTrue(anuncioVentaService.add(new AnuncioVenta(1l, "hola", "Rangel", EstadoMovil.intacto, "intercambio",
				95f, new ArrayList<PeticionVenta>())));
	}

	@Test
	void testFindAllByUsername() {
		mongoTemplate.getCollection("AnuncioVenta").drop();
		AnuncioVenta anuncio = new AnuncioVenta(1l, "hola", "Rangel", EstadoMovil.intacto, "intercambio", 95f,
				new ArrayList<PeticionVenta>());
		assertTrue(anuncioVentaService.add(anuncio));
		AnuncioVenta anuncio1 = new AnuncioVenta(2l, "hola", "Rangel", EstadoMovil.intacto, "intercambio", 100f,
				new ArrayList<PeticionVenta>());
		assertTrue(anuncioVentaService.add(anuncio1));

		List<AnuncioVenta> anuncios = new ArrayList<>();
		anuncios = anuncioVentaService.getAllByUsername("Rangel");
		System.out.println(anuncios.get(0).toString());
		assertEquals(anuncio, anuncios.get(0));
		assertNotNull(anuncios.get(1));

	}

}
