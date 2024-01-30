package com.adorno.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.modelo.Marca;
import com.adorno.services.MarcaService;

@RestController
@RequestMapping("marca")
public class MarcaController implements Controller<String> {

	private final MarcaService marcaService;
	
	public MarcaController(MarcaService marcaService) {
		super();
		this.marcaService = marcaService;
	}
	@Override
	public List<String> all() {
		return marcaService.findAll();
	}

	@Override
	public String findById(@PathVariable long id) {
		return marcaService.getById(id).orElse("no existe la marca");
	}

	@Override
	public boolean insert(@RequestBody String t) {
		return marcaService.add(t);
	}

	@Override
	public boolean insertAll(@RequestBody List<String> t) {
		return marcaService.addAll(t);
	}

	@Override
	public boolean delete(@PathVariable long id) {
		return marcaService.delete(id);
	}

}
