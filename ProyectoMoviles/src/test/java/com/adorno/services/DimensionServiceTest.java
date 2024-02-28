package com.adorno.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.sql.Dimension;

@SpringBootTest
class DimensionServiceTest {

	@Autowired
	DimensionService dimensionService;
	
	private Dimension dimension= new Dimension(1L, 1, 2, 3);
	
	
	@Test
	void testAdd() {
		assertTrue(dimensionService.add(dimension));
	}

	@Test
	void testDelete() {
		dimensionService.add(dimension);
		assertTrue(dimensionService.delete(1L));
	}

	@Test
	void testGetDimensionById() {
		dimensionService.add(dimension);
		assertTrue(dimensionService.getById(2L).isPresent());
	}

	@Test
	void testFindAll() {
		assertTrue(!dimensionService.findAll().isEmpty());
	}

}
