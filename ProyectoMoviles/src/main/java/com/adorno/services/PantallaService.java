package com.adorno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorno.modelo.Pantalla;
import com.adorno.repositorio.IPantallaRepositorio;

@Service
public class PantallaService {
	
	@Autowired
	IPantallaRepositorio pantallaRepo;
	
	public PantallaService() {
		super();
	}
	
	public boolean add(Pantalla pantalla) {
		return pantallaRepo.save(pantalla) != null;
	}
	
	public boolean delete (long id) {
		boolean retorno = pantallaRepo.findById(null).isPresent();
		if(retorno) {
			pantallaRepo.findById(id).ifPresent((pantalla)->{
				pantallaRepo.delete(pantalla);
			});
		}
		return retorno;
	}
	
	public Optional<Pantalla> getDimensionById(long id){
		return pantallaRepo.findById(id);
	}
	
	public List<Pantalla> findAll(){
		return pantallaRepo.findAll();	
		}
	
	public boolean insertarLista(List<Pantalla> insertados) {
		
		insertados.stream()
		.forEach((pantalla)->{
			pantallaRepo.save(pantalla);
		});

		return true;
	}
	
	
	
	

}
