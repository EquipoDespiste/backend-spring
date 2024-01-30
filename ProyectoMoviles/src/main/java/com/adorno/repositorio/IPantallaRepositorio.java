package com.adorno.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adorno.modelo.Pantalla;

@Repository
public interface IPantallaRepositorio extends JpaRepository<Pantalla, Long>{
	
	public List<Pantalla>findByTecnologia(String tecnologia);

}
