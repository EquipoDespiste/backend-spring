package com.adorno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adorno.modelo.Movil;
import com.adorno.repositorio.IMovilRepositorio;
import com.adorno.repositorio.MovilRepositorio;
@Service
public class MovilService {
	
	IMovilRepositorio movilRepo;
	
	public MovilService() {
		super();
		movilRepo = new MovilRepositorio();
	}
	
	public boolean add(Movil movil) {
		return movilRepo.save(movil);
	}
	
	public boolean delete (long id) {
		boolean retorno = movilRepo.findById(id).isPresent();
		if(retorno) {
			movilRepo.findById(id).ifPresent((movil)->{
				movilRepo.delete(movil);
			});
		}
		
		return retorno;
	}
	
	public Optional<Movil> getMovilById(long id){
		return movilRepo.findById(id);
	}

	public List<Movil> obtenerMoviles() {
		return movilRepo.obtenerMoviles();
	}

	
	//devuelvo true porque funciona y porque no hay otro metodo
	public boolean insertarLista(List<Movil> insertados) {
			insertados.stream()
			.forEach((movil)->{
				movilRepo.save(movil);
			});	
			return true;
	}
}
