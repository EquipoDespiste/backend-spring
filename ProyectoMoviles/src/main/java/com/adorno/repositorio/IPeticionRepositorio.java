package com.adorno.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adorno.modelo.Peticion;

public interface IPeticionRepositorio extends JpaRepository<Peticion, Long>{
//hay que mirarlo , me lio con los estados.
	//necesito los estados de los moviles que esta en 
	//los anuncios,
	//A los anuncios se accede a traves de la ID
	//es chungo
	
	public List<Peticion> findByTipo();
	public List<Peticion> findByEstado();
	public List<Peticion> findByFecha();
	
	
}
