package com.adorno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorno.modelo.sql.Procesador;
import com.adorno.repositorio.IProcesadorRepositorio;

@Service
public class ProcesadorService implements Services<Procesador>{

	
	private final IProcesadorRepositorio procesadorRepo;
	
	public ProcesadorService(IProcesadorRepositorio procesadorRepo) {
		super();
		this.procesadorRepo=procesadorRepo;
	}

	@Override
	public boolean add(Procesador procesador) {
		
		//return procesadorRepo.save(procesador) != null;
		Optional<Procesador> procesadorO = Optional.ofNullable(procesadorRepo.findByTipoIgnoreCase(procesador.getTipo()));
		if (!procesadorO.isPresent()) {
			return procesadorRepo.save(new Procesador(procesador.getTipo(),procesador.getNucleos(),procesador.getVelocidad_max())) != null;
		}
		return false;
		
		
		
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
//		procesadores.stream()
//		.forEach((procesador)->{
//			procesadorRepo.save(procesador);
//		});
		this.procesadorRepo.saveAll(procesadores);
		return  true;
		
		
		
		
		
		
		
	}
	
	
}
