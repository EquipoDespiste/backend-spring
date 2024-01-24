package com.adorno.controllers;

import java.util.List;

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
@RequestMapping("dimension")
public class DimensionController {

	private final DimensionService dimensionService;

	public DimensionController(DimensionService dimensionService) {
		super();
		this.dimensionService = dimensionService;
	}

	@GetMapping("all")
	public List<Dimension> dimensiones() {
		return dimensionService.findAll();
	}

	@GetMapping("busqueda/{id}")
	public Dimension encontrarDimension(@PathVariable long id) {
		return dimensionService.getDimensionById(id).orElse(new Dimension());
	}

	@PostMapping("insertar")
	public boolean insertar(@RequestBody Dimension dimension) {
		return dimensionService.add(dimension);
	}

	@PostMapping("insertar-lista")
	public boolean insertarLista(@RequestBody List<Dimension> dimensiones) {
		return dimensionService.insertarLista(dimensiones);
	}

	@DeleteMapping("delete/{id}")
	public boolean borrar(@PathVariable long id) {
		return dimensionService.delete(id);
	}

}
