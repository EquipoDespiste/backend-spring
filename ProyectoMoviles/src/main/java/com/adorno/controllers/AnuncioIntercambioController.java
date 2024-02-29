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

import com.adorno.modelo.mongo.AnuncioIntercambio;
import com.adorno.services.AnuncioIntercambioService;

@RestController
@RequestMapping("anuncioIntercambio")
public class AnuncioIntercambioController {
	
	private final AnuncioIntercambioService anuncioIntercambioService;

	public AnuncioIntercambioController(AnuncioIntercambioService anuncioIntercambioService) {
		super();
		this.anuncioIntercambioService = anuncioIntercambioService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<AnuncioIntercambio>> all() {
		return Optional.of(new ResponseEntity<List<AnuncioIntercambio>>(anuncioIntercambioService.findAll(),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<AnuncioIntercambio> findById(@PathVariable ObjectId id) {
		return Optional.of(new ResponseEntity<AnuncioIntercambio>(anuncioIntercambioService.getById(id).get(), HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/insertar")
	public ResponseEntity<Boolean> insert(@RequestBody AnuncioIntercambio anuncio) {
		return Optional.of(new ResponseEntity<Boolean>(anuncioIntercambioService.add(anuncio),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
	}
	
	@PostMapping("/insertar-lista")
	public ResponseEntity<Boolean> insertAll(@RequestBody List<AnuncioIntercambio> anuncio) {
		return Optional.of(new ResponseEntity<Boolean>(anuncioIntercambioService.addAll(anuncio),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable ObjectId id) {
		return Optional.of(new ResponseEntity<Boolean>(anuncioIntercambioService.delete(id),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}
}
