package com.adorno.controllers;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.modelo.mongo.AnuncioVenta;
import com.adorno.modelo.mongo.EstadoAnuncio;
import com.adorno.services.AnuncioVentaService;

@RestController
@RequestMapping("anuncioVentaController")
public class AnuncioVentaController {
	
	private final AnuncioVentaService anuncioVentaService;

	public AnuncioVentaController(AnuncioVentaService anuncioVentaService) {
		super();
		this.anuncioVentaService = anuncioVentaService;
	}
	@GetMapping("/all")
	public ResponseEntity<List<AnuncioVenta>> all() {
		return Optional.of(new ResponseEntity<List<AnuncioVenta>>(anuncioVentaService.findAll(),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<AnuncioVenta> findById(@PathVariable ObjectId id) {
		return Optional.of(new ResponseEntity<AnuncioVenta>(anuncioVentaService.getById(id).get(), HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<List<AnuncioVenta>> getAllEstadoAnuncio(@PathVariable EstadoAnuncio estadoAnuncio){
		return Optional.of(new ResponseEntity<List<AnuncioVenta>>(anuncioVentaService.findAllEstadoAnuncio(estadoAnuncio),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		
	}
	
	
	@PostMapping("/insertar")
	public ResponseEntity<Boolean> insert(@RequestBody AnuncioVenta anuncio) {
		return Optional.of(new ResponseEntity<Boolean>(anuncioVentaService.add(anuncio),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable ObjectId id) {
		return Optional.of(new ResponseEntity<Boolean>(anuncioVentaService.delete(id),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}
	
}
