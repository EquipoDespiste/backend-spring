package com.adorno.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adorno.modelo.sql.Dimension;
@Repository
public interface IDimensionRepositorio extends JpaRepository<Dimension, Long>{
	
	

}
