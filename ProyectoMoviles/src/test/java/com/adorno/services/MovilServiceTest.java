package com.adorno.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.adorno.modelo.Movil;
<<<<<<< Updated upstream
import com.adorno.repositorio.IMovilRepositorio;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;


=======
>>>>>>> Stashed changes

class MovilServiceTest {

<<<<<<< Updated upstream
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
	
=======
	@Autowired
	MovilService movilservicio = new MovilService();

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
>>>>>>> Stashed changes

}