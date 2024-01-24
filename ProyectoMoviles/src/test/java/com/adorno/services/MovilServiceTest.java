package com.adorno.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.Movil;
import com.adorno.repositorio.IMovilRepositorio;


@SpringBootTest
class MovilServiceTest {


MovilService movilservicio= new MovilService();

@Autowired
IMovilRepositorio movilrepo;

	@Test
	void testAdd() {
		movilservicio.add(new Movil("modelo1", "Marca1", 1, 2, 1, 2, 1, false, 1, 1f));
	
		assertTrue(movilrepo.findById(1l).get().getMarca().equalsIgnoreCase("Marca1"));
	}
/*
	@Ignore
	void testDelete() {
		fail("Not yet implemented");
	}

	@Ignore
	void testGetMovilById() {
		fail("Not yet implemented");
	}

	@Ignore
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Ignore
	void testInsertarLista() {
		fail("Not yet implemented");
	}
	*/

}
