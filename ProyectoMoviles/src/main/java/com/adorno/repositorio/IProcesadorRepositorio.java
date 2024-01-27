package com.adorno.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adorno.modelo.Procesador;
@Repository
public interface IProcesadorRepositorio extends JpaRepository<Procesador, Long>{

	
	
}
