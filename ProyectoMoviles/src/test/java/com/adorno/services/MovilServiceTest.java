package com.adorno.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.adorno.modelo.Movil;
import com.adorno.repositorio.IMovilRepositorio;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;



class MovilServiceTest {


MovilService movilservicio= new MovilService();
@Autowired
IMovilRepositorio movilrepo;
	@Test
	void testAdd() {
		movilservicio.add(new Movil(1L, "modelo1", "Marca1", 1, 2, 1, 2, 1, false, 1, 1f));
	
		assertTrue(movilrepo.findById(1l).get().getMarca().equalsIgnoreCase("Marca1"));
	}
/*
	@IgnoreForBinding
	void testDelete() {
		fail("Not yet implemented");
	}

	@IgnoreForBinding
	void testGetMovilById() {
		fail("Not yet implemented");
	}

	@IgnoreForBinding
	void testFindAll() {
		fail("Not yet implemented");
	}

	@IgnoreForBinding
	void testInsertarLista() {
		fail("Not yet implemented");
	}
	*/

}
