package com.adorno.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adorno.modelo.sql.Marca;
import com.adorno.modelo.sql.Movil;

@Repository
public interface IMovilRepositorio extends JpaRepository<Movil, Long>{

	public List<Movil> findAllByMarca(Marca marca);



	public List<Movil> findByNfc(boolean nfc);
	

	
}
