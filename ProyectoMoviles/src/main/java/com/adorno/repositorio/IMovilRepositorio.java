package com.adorno.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adorno.modelo.Movil;

public interface IMovilRepositorio {
	
	public boolean save (Movil movil);
	public boolean delete(Movil movil);
	public Optional<Movil> findById(long id);
	public List<Movil> obtenerMoviles();

	
	

}
