package com.adorno.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.adorno.modelo.Movil;
import com.adorno.repositorio.IMovilRepositorio;


@Service
public class MovilService {
	@Autowired
	IMovilRepositorio movilRepo;
	
	public MovilService() {
		super();
		
	}
	
	public boolean add(Movil movil) {
		return movilRepo.save(movil) != null;
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

	public List<Movil> findAll() {
		return movilRepo.findAll();
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
