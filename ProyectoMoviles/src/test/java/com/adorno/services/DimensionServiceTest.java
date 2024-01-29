package com.adorno.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.adorno.repositorio.IDimensionRepositorio;

@SpringBootTest
class DimensionServiceTest {

	@Autowired
	DimensionService dimensionService;
	
	
	
	@Test
	void testAdd() {
		
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDimensionById() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testInsertarLista() {
		fail("Not yet implemented");
	}

}
