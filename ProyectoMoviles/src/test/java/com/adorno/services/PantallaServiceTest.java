package com.adorno.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.sql.Pantalla;

@SpringBootTest
class PantallaServiceTest {

	@Autowired
	PantallaService pantallaService;
	
	List<Pantalla>listaPantalla=new ArrayList<>();
	private Pantalla pantalla;
	
	@BeforeEach
	void before() {
		pantalla=new Pantalla(1L,15.15f, "tecnologia1");
		
	}
	
	@Test
	void testAdd() {
		assertTrue(pantallaService.add(pantalla));
	}

	@Test
	void testDelete() {
		assertTrue(pantallaService.delete(1L));
	}

	@Test
	void testGetDimensionById() {
		pantallaService.add(pantalla);
		float esperado=15.15f;
		float tamanio= pantallaService.getById(2L).get().getTamanio();
		assertEquals(esperado, tamanio);
	}

	@Test
	void testFindAll() {
		assertTrue(!pantallaService.findAll().isEmpty());
	}

	@Test
	void testInsertarLista() {
		assertTrue(pantallaService.addAll(listaPantalla));
	}

}
