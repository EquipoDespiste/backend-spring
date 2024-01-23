package com.adorno.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.adorno.modelo.Movil;

public class MovilRepositorio implements IMovilRepositorio{

	List<Movil> moviles;
	
	public MovilRepositorio() {
		super();
		this.moviles = new ArrayList<>();
	}
	@Override
	public boolean save(Movil movil) {
		
		return this.moviles.add(movil);
	}

	
	@Override
	public boolean delete(Movil movil) {

		return this.moviles.remove(movil);
	}

	@Override
	public Optional<Movil> findById(long id) {

		return moviles.stream()
				.filter((movil)->{
					return movil.getId() == id;
				})
				.findFirst();
	}
	@Override
	public List<Movil> obtenerMoviles() {
		return moviles.stream()	
				.toList();
		}
	
}
