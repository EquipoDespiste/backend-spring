package com.adorno.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.Marca;
import com.adorno.modelo.Movil;
import com.adorno.repositorio.IMarcaRepositorio;

@SpringBootTest
class MovilServiceTest {

	@Autowired
	MovilService movilservicio;
	@Autowired
	IMarcaRepositorio marcaRepo;

	private List<Movil> listaMoviles = new ArrayList<>() ;

	private Movil movil;

	@BeforeEach
	void before() {
		
		listaMoviles.add(new Movil("modelo1",  1, 2, 1f, 2, 1, false, 1, 1f));
		movil= new Movil("modelo1",  1, 2, 1f, 2, 1, false, 1, 1f);
	}

	@Test
	void testAdd() {
		
		assertTrue(movilservicio.add(movil));
	}

	@Test
	void testDelete() {
		
		movilservicio.add(movil);
		assertTrue(movilservicio.delete(1L));
	}

	@Test
	void testGetMovilById() {
		
		movilservicio.add(movil);
		assertTrue(movilservicio.getById(1L).isPresent());

	}

	@Test
	void testFindAll() {

		movilservicio.add(movil);
		assertTrue(!movilservicio.findAll().isEmpty());
	}

	@Test
	void testInsertarLista() {
	
		movilservicio.addAll(listaMoviles);
		listaMoviles.forEach((movil) -> {
			System.out.println(movil.getMarca());
		});
		System.out.println(movilservicio.findAll().isEmpty());
		assertTrue(!movilservicio.findAll().isEmpty());
	}

	@Test
	void testFindBydMarca() {
		Marca marca = new Marca("Apple");
		movil = new Movil("modelo1",  1, 2, 1f, 2, 1, false, 1, 1f, marca);
		
		listaMoviles.add(movil);
		movilservicio.addAll(listaMoviles);
		int esperado = 1;
		int actual = movilservicio.findByMarca("Apple").size();
		assertTrue(movilservicio.findByMarca("Apple") != null);
		assertEquals(esperado, actual);
	}
	
	//TODO test de filtrado, si quereis, podemos hacerlo en varios test para no congestionar todo el test
	@Test
	void testFiltrado() {
		
		
				
	}
}