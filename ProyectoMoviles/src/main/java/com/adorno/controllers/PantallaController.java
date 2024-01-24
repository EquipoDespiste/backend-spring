package com.adorno.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.modelo.Pantalla;
import com.adorno.services.PantallaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("pantalla")
public class PantallaController {

	private final PantallaService pantallaService;

	public PantallaController(PantallaService pantallaService) {
		super();
		this.pantallaService = pantallaService;
	}

	@GetMapping("all")
	public List<Pantalla> dimensiones() {
		return pantallaService.findAll();
	}

	@GetMapping("busqueda/{id}")
	public Pantalla encontrarDimension(@PathVariable long id) {
		return pantallaService.getDimensionById(id).orElse(new Pantalla());
	}

	@PostMapping("insertar")
	public boolean insertar(@RequestBody Pantalla pantalla) {
		return pantallaService.add(pantalla);
	}

	@PostMapping("insertar-lista")
	public boolean insertarLista (@RequestBody List<Pantalla> pantalla) {
		return pantallaService.insertarLista(pantalla);
	}

	@DeleteMapping("delete/{id}")
	public boolean borrar(@PathVariable long id) {
		return pantallaService.delete(id);
	}

}
