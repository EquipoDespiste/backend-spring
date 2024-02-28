package com.adorno.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.modelo.sql.Procesador;
import com.adorno.services.ProcesadorService;

@RestController
@RequestMapping("procesadores")
public class ProcesadorController {
	private final ProcesadorService procesadorService;

	public ProcesadorController(ProcesadorService procesadorService) {
		super();
		this.procesadorService = procesadorService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Procesador>> all() {
		return Optional.of(new ResponseEntity<List<Procesador>>(procesadorService.findAll(), HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Procesador> findById(@PathVariable long id) {
		return Optional.of(new ResponseEntity<Procesador>(procesadorService.getById(id).get(), HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND ));
	}

	@PostMapping("/insertar")
	public ResponseEntity<Boolean> insert(@RequestBody Procesador  procesador) {
	
		return Optional.of(new ResponseEntity<Boolean>(procesadorService.add(procesador),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
		
	}

	@PostMapping("/insertar-lista")
	public ResponseEntity<Boolean> insertAll(@RequestBody List<Procesador> procesadores) {

		return Optional.of(new ResponseEntity<Boolean>(procesadorService.addAll(procesadores),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		
	}

	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return Optional.of(new ResponseEntity<Boolean>(procesadorService.delete(id),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		
	}

}
