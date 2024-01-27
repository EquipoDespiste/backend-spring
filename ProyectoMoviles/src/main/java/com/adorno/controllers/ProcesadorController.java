package com.adorno.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.modelo.Procesador;
import com.adorno.services.ProcesadorService;

@RestController
@RequestMapping("procesadores")
public class ProcesadorController implements Controller<Procesador> {
	private final ProcesadorService procesadorService;

	public ProcesadorController(ProcesadorService procesadorService) {
		super();
		this.procesadorService = procesadorService;
	}

	@Override
	public List<Procesador> all() {
		return procesadorService.findAll();
	}

	@Override
	public Procesador findById(long id) {
		return procesadorService.getById(id).orElse(new Procesador());
	}

	@Override
	public boolean insert(Procesador procesador) {
		return procesadorService.add(procesador);
	}

	@Override
	public boolean insertAll(List<Procesador> procesadores) {
		return procesadorService.addAll(procesadores);
	}

	@Override
	@DeleteMapping("delete/{id}")
	public boolean delete(long id) {
		return procesadorService.delete(id);
	}

}
