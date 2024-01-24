package com.adorno.controllers;

import java.util.List;

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
@RequestMapping("movil")
public class MovilController {

	private final MovilService movilService;

	public MovilController(MovilService movilService) {
		super();
		this.movilService = movilService;
	}

	@GetMapping("all")
	public List<Movil> moviles() {
		return movilService.findAll();
	}

	@GetMapping("busqueda/{id}")
	public Movil encontrarMovil(@PathVariable long id) {
		return movilService.getMovilById(id).orElse(new Movil());
	}

	@PostMapping("insercion")
	public boolean insertarMovil(@RequestBody Movil movil) {
		return movilService.add(movil);
	}

	@PostMapping("insertar-lista")
	public boolean insertarLista(@RequestBody List<Movil> moviles) {
		return movilService.insertarLista(moviles);
	}

	@DeleteMapping("delete/{id}")
	public boolean borrarMovil(@PathVariable long id) {
		return movilService.delete(id);
	}

}
