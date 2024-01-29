package com.adorno.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.Procesador;
@SpringBootTest
class ProcesadorServiceTest {
	@Autowired
	ProcesadorService service;
	
	@Test
	void testAdd() {
		Procesador procesador=new Procesador("PGA",12,2.1f);
		assertTrue(service.add(procesador));
	}

	@Test
	void testDelete() {
		
		assertTrue(service.delete(1));
	}

	@Test
	void testGetById() {
		Long esperado=1l;
		Long actual=service.getById(1l).get().getId();
		assertEquals(esperado,actual);

	}

	@Test
	void testFindAll() {
		assertTrue(service.findAll()!=null);
	}

	@Test
	void testAddAll() {
		List<Procesador>lista=new ArrayList<>();
		lista.add(new Procesador("PGA",12,2.1f));
		lista.add(new Procesador("AvA",1,2.1f));
		lista.add(new Procesador("PFA",2,1.1f));
		
		assertTrue(service.addAll(lista));
		
	}

}
