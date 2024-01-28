package com.adorno.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adorno.modelo.Movil;




@SpringBootTest
class MovilServiceTest {

@Autowired
MovilService movilservicio= new MovilService();




	private List<Movil> listaMoviles = new ArrayList<>();

	private Movil movil;

	@BeforeEach
	void before() {
		listaMoviles.add(new Movil("modelo1", "Marca1", 1, 2, 1f, 2, 1, false, 1, 1f));
		movil = new Movil("modelo1", "Marca1", 1, 2, 1f, 2, 1, false, 1, 1f);
	}

	@Test
	void testAdd() {
		 movil = Mockito.mock(Movil.class);
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
		 movil = Mockito.mock(Movil.class);
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
	movil = new Movil("modelo1", "Marca2", 1, 2, 1f, 2, 1, false, 1, 1f);
	listaMoviles.add(movil);
	movilservicio.addAll(listaMoviles);
	
	int esperado=1;
	int actual=movilservicio.findByMarca("Marca2").size();
	assertTrue(movilservicio.findByMarca("Marca2")!=null);
	assertEquals(esperado,actual);
}
}