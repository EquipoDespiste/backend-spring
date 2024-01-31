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

import com.adorno.modelo.Movil;
import com.adorno.services.MovilService;

@RestController
@RequestMapping("moviles")
public class MovilController {

	private final MovilService movilService;

	public MovilController(MovilService movilService) {
		super();
		this.movilService = movilService;
	}

	@GetMapping("/all")
	public ResponseEntity<List<Movil>> addAll(){
		
		return Optional.of(new ResponseEntity<List<Movil>>(movilService.findAll(),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Movil> findById(@PathVariable long id) {
		
		return Optional.of(new ResponseEntity<Movil>(movilService.getById(id).get(), HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/insercion")
	public ResponseEntity<Boolean> insert(@RequestBody Movil movil) {
		
		
		return Optional.of(new ResponseEntity<Boolean>(movilService.add(movil),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
		
	}

	@PostMapping("/insertar-lista")
	public ResponseEntity<Boolean> insertAll(@RequestBody List<Movil> moviles) {
		
		return Optional.of(new ResponseEntity<Boolean>(movilService.addAll(moviles),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
	
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		
		return Optional.of(new ResponseEntity<Boolean>(movilService.delete(id),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		
	}
	
	
	@GetMapping("find/{marca}")
	public ResponseEntity<List<Movil>> findByMarca(@PathVariable String marca) {
		
		return Optional.of(new ResponseEntity<List<Movil>>(movilService.findByMarca(marca),HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		
		
	}

	

	
	

}
