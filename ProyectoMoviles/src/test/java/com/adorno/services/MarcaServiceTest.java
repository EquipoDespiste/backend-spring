package com.adorno.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.sql.Marca;
import com.adorno.modelo.sql.Movil;

@SpringBootTest
class MarcaServiceTest {

	@Autowired
	MarcaService marcaService;

	private List<Marca> listaMarcas;
	private Marca marca;

	@BeforeEach
	void before() {
		listaMarcas = new ArrayList<>();
	}

	@Test
	void testAdd() {
		assertTrue(marcaService.add("marca1"));
	}

	@Test
	void testGetById() {
		marcaService.add("marca1");
		assertTrue(marcaService.getById(1L).isPresent());
	}

	@Test
	void testFindAll() {
		List<String> marcas = new ArrayList<>();
		marcas.add("Nokia");
		
		marcaService.add("marca1");
		assertTrue(!marcaService.findAll().isEmpty());
		
		assertTrue(!marcas.isEmpty());
	}
	
	@Test
	void insertAll() {
		List<String> marcas = new ArrayList<>();
		marcas.add("nokia");
		marcas.add("samsung");
		marcas.add("Hawuei");
		marcas.addAll(marcas);
		marcaService.addAll(marcas);
		
		
	}

}
