package com.adorno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorno.modelo.sql.Pantalla;
import com.adorno.repositorio.IPantallaRepositorio;

@Service
public class PantallaService implements Services<Pantalla>{
	
	
	private final IPantallaRepositorio pantallaRepo;
	
	public PantallaService(IPantallaRepositorio pantallaRepo) {
		super();
		this.pantallaRepo=pantallaRepo;
	}
	@Override
	public boolean add(Pantalla pantalla) {
		return pantallaRepo.save(pantalla) != null;
	}
	@Override
	public boolean delete (long id) {
		boolean retorno = pantallaRepo.findById(id).isPresent();
		if(retorno) {
			pantallaRepo.findById(id).ifPresent((pantalla)->{
				pantallaRepo.delete(pantalla);
			});
		}
		return retorno;
	}
	@Override
	public Optional<Pantalla> getById(long id){
		return pantallaRepo.findById(id);
	}
	@Override
	public List<Pantalla> findAll(){
		return pantallaRepo.findAll();	
		}
	@Override
	public boolean addAll(List<Pantalla> insertados) {
		
		insertados.stream()
		.forEach((pantalla)->{
			pantallaRepo.save(pantalla);
		});

		return true;
	}
	
	
	public List<Pantalla> findByTecnologiaPantalla(String tecnlogia){
		return pantallaRepo.findByTecnologia(tecnlogia);
	}
	

}
