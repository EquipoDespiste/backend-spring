package com.adorno.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.Marca;

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
		marcaService.add("marca1");
		assertTrue(!marcaService.findAll().isEmpty());
	}

}
