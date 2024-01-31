package com.adorno.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.adorno.modelo.Marca;
import com.adorno.modelo.Movil;

@Repository
public interface IMovilRepositorio extends JpaRepository<Movil, Long>{

	public List<Movil> findByMarca(Marca marca);



	public List<Movil> findByNfc(boolean nfc);
	

	
}
