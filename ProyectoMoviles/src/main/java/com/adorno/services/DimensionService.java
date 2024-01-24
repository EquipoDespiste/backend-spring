package com.adorno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorno.modelo.Dimension;
import com.adorno.repositorio.IDimensionRepositorio;

@Service
public class DimensionService {
	
	@Autowired
	IDimensionRepositorio dimensionRepo;
	
	public DimensionService() {
		super();
	}
	
	public boolean add(Dimension dimension) {
		return dimensionRepo.save(dimension) != null;
	}
	
	public boolean delete (long id) {
		boolean retorno = dimensionRepo.findById(null).isPresent();
		if(retorno) {
			dimensionRepo.findById(id).ifPresent((dimension)->{
				dimensionRepo.delete(dimension);
			});
		}
		return retorno;
	}
	
	public Optional<Dimension> getDimensionById(long id){
		return dimensionRepo.findById(id);
	}
	
	public List<Dimension> findAll(){
		return dimensionRepo.findAll();	
		}
	
	public boolean insertarLista(List<Dimension> insertados) {
		
		insertados.stream()
		.forEach((dimension)->{
			dimensionRepo.save(dimension);
		});

		return true;
	}
	
	
	
	

}
