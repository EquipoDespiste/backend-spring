package com.adorno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorno.modelo.Procesador;
import com.adorno.repositorio.IProcesadorRepositorio;

@Service
public class ProcesadorService implements Services<Procesador>{

	@Autowired
	IProcesadorRepositorio procesadorRepo;
	
	public ProcesadorService() {
		super();
	}

	@Override
	public boolean add(Procesador procesador) {
		
		return procesadorRepo.save(procesador) != null;
	}

	@Override
	public boolean delete(long id) {
		boolean retorno = procesadorRepo.findById(id).isPresent();
		if (retorno) {
			procesadorRepo.findById(id).ifPresent((procesador)->{
				procesadorRepo.delete(procesador);
			});
		}
		return retorno;
	}

	@Override
	public Optional<Procesador> getById(long id) {
		return procesadorRepo.findById(id);
	}

	@Override
	public List<Procesador> findAll() {
		return procesadorRepo.findAll();
	}

	@Override
	public boolean addAll(List<Procesador> procesadores) {
		procesadores.stream()
		.forEach((procesador)->{
			procesadorRepo.save(procesador);
		});
		
		return true;
	}
	
	
}
