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

import com.adorno.modelo.mongo.PeticionIntercambio;
import com.adorno.modelo.sqlSecurity.UserEntity;
import com.adorno.services.PeticionIntercambioService;

@RestController
@RequestMapping("peticionintercambio")
public class PeticionIntercambioController {

	private final PeticionIntercambioService peticionIntercambioService;

	public PeticionIntercambioController(PeticionIntercambioService peticionIntercambioService) {
		super();
		this.peticionIntercambioService = peticionIntercambioService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<PeticionIntercambio>> all() {
		List<PeticionIntercambio> peticiones =  peticionIntercambioService.findAll();
		
		return ResponseEntity.ok().body(peticiones); 
	}
	
	@PostMapping("/insertar")
	public ResponseEntity<Boolean> insert(@RequestBody PeticionIntercambio t) {
		
		boolean isInsert= false;
		
		if(isInsert = peticionIntercambioService.add(t)) {
			return ResponseEntity.ok().body(isInsert);
		};
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isInsert);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		boolean idDelete= false;
		if(idDelete = peticionIntercambioService.delete(id)) {
			return ResponseEntity.ok().body(idDelete);
		};
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(idDelete);
	}
	
	@GetMapping("/findByPeticionUsuario")
	public ResponseEntity<Optional<List<PeticionIntercambio>>> getPeticionByUsuario(UserEntity usuario){
	
		Optional<List<PeticionIntercambio>> peticionesUsuario =  peticionIntercambioService.findByPeticionUser(usuario);
		
		return ResponseEntity.ok().body(peticionesUsuario);
		
	}
}
