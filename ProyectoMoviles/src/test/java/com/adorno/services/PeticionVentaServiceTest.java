package com.adorno.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.adorno.modelo.mongo.AnuncioVenta;
import com.adorno.modelo.mongo.EstadoMovil;
import com.adorno.modelo.mongo.PeticionVenta;
@SpringBootTest
class PeticionVentaServiceTest {

	@Autowired
	PeticionVentaService peticionVentaService;
	
	@Autowired
	AnuncioVentaService anuncioVentaService;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Test
	void test() {
		
		
		String id = "65e1a20e0e695b1938a73c29";
		ObjectId idObj = new ObjectId(id);
		
		mongoTemplate.getCollection("PeticionVenta").drop();
		mongoTemplate.getCollection("AnuncioVenta").drop();
		AnuncioVenta anuncio = new AnuncioVenta(1l, "hola", "Rangel", EstadoMovil.intacto, "intercambio", 95f, new ArrayList<PeticionVenta>());
		anuncioVentaService.add(anuncio);
		anuncio = anuncioVentaService.findAll().get(0);
		assertTrue(peticionVentaService.add(new PeticionVenta("username",idObj, "intercambio",LocalDate.now(),104f, anuncio)));
	}

}
