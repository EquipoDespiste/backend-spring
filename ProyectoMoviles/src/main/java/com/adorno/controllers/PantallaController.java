package com.adorno.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.modelo.sql.Movil;
import com.adorno.modelo.sql.Pantalla;
import com.adorno.services.PantallaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("pantallas")
public class PantallaController {

	private final PantallaService pantallaService;

	public PantallaController(PantallaService pantallaService) {
		super();
		this.pantallaService = pantallaService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Pantalla>> all() {
		return Optional.of(new ResponseEntity<List<Pantalla>>(pantallaService.findAll(),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));

	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Pantalla> findById(@PathVariable long id) {
		return Optional.of(new ResponseEntity<Pantalla>(pantallaService.getById(id).get(), HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}
	@PostMapping("/insertar")
	public  ResponseEntity<Boolean>  insert(@RequestBody Pantalla pantalla) {
		return Optional.of(new ResponseEntity<Boolean>(pantallaService.add(pantalla),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
	}
	@PostMapping("/insertar-lista")
	public ResponseEntity<Boolean> insertAll (@RequestBody List<Pantalla> pantalla) {
		return Optional.of(new ResponseEntity<Boolean>(pantallaService.addAll(pantalla),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return Optional.of(new ResponseEntity<Boolean>(pantallaService.delete(id),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}

}
