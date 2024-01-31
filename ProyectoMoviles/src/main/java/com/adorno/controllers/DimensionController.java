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

import com.adorno.modelo.Dimension;
import com.adorno.services.DimensionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("dimensiones")
public class DimensionController {

	private final DimensionService dimensionService;

	public DimensionController(DimensionService dimensionService) {
		super();
		this.dimensionService = dimensionService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Dimension>> all() {
		return Optional.of(new ResponseEntity<List<Dimension>>(dimensionService.findAll(),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Dimension> findById(@PathVariable long id) {
		return Optional.of(new ResponseEntity<Dimension>(dimensionService.getById(id).get(), HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/insertar")
	public ResponseEntity<Boolean> insert(@RequestBody Dimension dimension) {
		return Optional.of(new ResponseEntity<Boolean>(dimensionService.add(dimension),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
	}
	
	@PostMapping("/insertar-lista")
	public ResponseEntity<Boolean> insertAll(@RequestBody List<Dimension> dimensiones) {
		return Optional.of(new ResponseEntity<Boolean>(dimensionService.addAll(dimensiones),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return Optional.of(new ResponseEntity<Boolean>(dimensionService.delete(id),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}

}
