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
@RequestMapping("pantallas")
public class PantallaController implements Controller<Pantalla>{

	private final PantallaService pantallaService;

	public PantallaController(PantallaService pantallaService) {
		super();
		this.pantallaService = pantallaService;
	}
	
	@Override
	public List<Pantalla> all() {
		return pantallaService.findAll();
	}
	@Override
	public Pantalla findById(@PathVariable long id) {
		return pantallaService.getById(id).orElse(new Pantalla());
	}
	@Override
	public boolean insert(@RequestBody Pantalla pantalla) {
		return pantallaService.add(pantalla);
	}
	@Override
	public boolean insertAll (@RequestBody List<Pantalla> pantalla) {
		return pantallaService.addAll(pantalla);
	}
	@Override
	public boolean delete(@PathVariable long id) {
		return pantallaService.delete(id);
	}

}
