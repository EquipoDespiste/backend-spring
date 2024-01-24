package com.adorno.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.adorno.modelo.Movil;
import com.adorno.repositorio.IMovilRepositorio;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;



class MovilServiceTest {

@Autowired
MovilService movilservicio= new MovilService();
@Autowired
IMovilRepositorio movilrepo;
	@Test
	void testAdd() {
		movilservicio.add(new Movil(1L, "modelo1", "Marca1", 1, 2, 1, 2, 1, false, 1, 1f));
		assertTrue(movilrepo.findById(1l).get().getMarca().equalsIgnoreCase("Marca1"));
	}
	
	

	@IgnoreForBinding
	void testDelete() {
		movilservicio.add(new Movil(1L, "modelo1", "Marca1", 1, 2, 1, 2, 1, false, 1, 1f));
		assertFalse(movilservicio.delete(0));
	}

	@IgnoreForBinding
	void testGetMovilById() {
		movilservicio.add(new Movil(1L, "modelo1", "Marca1", 1, 2, 1, 2, 1, false, 1, 1f));
		assertTrue(movilservicio.getById(1L).get().getModelo().equalsIgnoreCase("modelo1"));
		
	}

	@IgnoreForBinding
	void testFindAll() {
		
	}

	@IgnoreForBinding
	void testInsertarLista() {
		
	}
	

}
