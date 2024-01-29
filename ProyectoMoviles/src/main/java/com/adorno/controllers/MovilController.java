package com.adorno.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.modelo.Marca;
import com.adorno.modelo.Movil;
import com.adorno.services.MovilService;

@RestController
@RequestMapping("moviles")
public class MovilController implements Controller<Movil>{

	private final MovilService movilService;

	public MovilController(MovilService movilService) {
		super();
		this.movilService = movilService;
	}

	@Override
	public List<Movil> all() {
		return movilService.findAll();
	}

	@Override
	public Movil findById(@PathVariable long id) {
		return movilService.getById(id).orElse(new Movil());
	}

	@Override
	public boolean insert(@RequestBody Movil movil) {
		return movilService.add(movil);
	}

	@Override
	public boolean insertAll(@RequestBody List<Movil> moviles) {
		return movilService.addAll(moviles);
	}

	@Override
	public boolean delete(@PathVariable long id) {
		return movilService.delete(id);
	}
	
	
	@GetMapping("find/{marca}")
	public List<Movil> findByMarca(@PathVariable String marca) {
		
		return movilService.findByMarca(marca);
	}

}
