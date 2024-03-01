package com.adorno.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.adorno.modelo.mongo.PeticionIntercambio;

@SpringBootTest
public class PeticionIntercambioServiceTest {


	@Autowired
	PeticionIntercambioService peticionIntercambioService;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Test
	void test() {
		String id_peticion="prueba";
		ObjectId idObject= new ObjectId(id_peticion);
		
		String id_anuvio="anuncio";
		ObjectId idanucio= new ObjectId(id_anuvio);
		
		mongoTemplate.getCollection("peticionintercambio").drop();
		assertTrue(peticionIntercambioService.add(new PeticionIntercambio("username", idObject, "intercambio",LocalDate.now(), idanucio)));
	}

}
