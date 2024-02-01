package com.adorno.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.modelo.Marca;
import com.adorno.services.MarcaService;

@RestController
@RequestMapping("marca")
public class MarcaController  {

	private final MarcaService marcaService;
	
	public MarcaController(MarcaService marcaService) {
		super();
		this.marcaService = marcaService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<String>> all() {
		List<String> marcas =  marcaService.findAll();
		
		return ResponseEntity.ok().body(marcas); 
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<String> findById(@PathVariable long id) {
		
		Optional<String> marca = marcaService.getById(id);
		
		if(marca.isPresent())
			return ResponseEntity.ok().body(marca.get());
		
		return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

	@PostMapping("/insertar")
	public ResponseEntity<Boolean> insert(@RequestBody String t) {
		
		boolean isInsert= false;
		
		if(isInsert = marcaService.add(t)) {
			return ResponseEntity.ok().body(isInsert);
		};
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isInsert);
	}

	@PostMapping("/insertar-lista")
	public ResponseEntity<Boolean> insertAll(@RequestBody List<String> t) {
		boolean isInsertAll= false;
		
		if(isInsertAll = marcaService.addAll(t)) {
			return ResponseEntity.ok().body(isInsertAll);
		};
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isInsertAll);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		boolean idDelete= false;
		if(idDelete = marcaService.delete(id)) {
			return ResponseEntity.ok().body(idDelete);
		};
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(idDelete);
	}

}
