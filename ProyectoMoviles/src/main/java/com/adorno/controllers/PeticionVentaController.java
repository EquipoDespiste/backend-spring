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

import com.adorno.modelo.mongo.PeticionIntercambio;
import com.adorno.modelo.mongo.PeticionVenta;
import com.adorno.modelo.sqlSecurity.UserEntity;
import com.adorno.services.PeticionVentaService;

@RestController
@RequestMapping("PeticionVentaController")
public class PeticionVentaController {
private final PeticionVentaService peticionVentaService;

public PeticionVentaController(PeticionVentaService peticionVentaService) {
	super();
	this.peticionVentaService = peticionVentaService;
}

@GetMapping("/all")
public ResponseEntity<List<PeticionVenta>> all() {
	List<PeticionVenta> peticiones =  peticionVentaService.findAll();
	return ResponseEntity.ok().body(peticiones); 
}

@PostMapping("/insertar")
public ResponseEntity<Boolean> insert(@RequestBody PeticionVenta t) {
	
	boolean isInsert= false;
	
	if(isInsert = peticionVentaService.add(t)) {
		return ResponseEntity.ok().body(isInsert);
	};
	
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isInsert);
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<Boolean> delete(@PathVariable ObjectId id) {
	boolean idDelete= false;
	if(idDelete = peticionVentaService.delete(id)) {
		return ResponseEntity.ok().body(idDelete);
	};
	
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(idDelete);
}

@GetMapping("/findByPeticionUsuario")
public ResponseEntity<Optional<List<PeticionVenta>>> getPeticionByUsuario(@RequestBody UserEntity usuario){

	Optional<List<PeticionVenta>> peticionesUsuario =  peticionVentaService.findByPeticionUser(usuario);
	
	return ResponseEntity.ok().body(peticionesUsuario);
	
}

}
