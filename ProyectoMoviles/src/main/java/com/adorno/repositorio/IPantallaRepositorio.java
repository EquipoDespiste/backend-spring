package com.adorno.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adorno.modelo.Pantalla;

@Repository
public interface IPantallaRepositorio extends JpaRepository<Pantalla, Long>{
	
	

}
