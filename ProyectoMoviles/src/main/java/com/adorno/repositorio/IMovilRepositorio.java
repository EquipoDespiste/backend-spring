package com.adorno.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adorno.modelo.Movil;

@Repository
public interface IMovilRepositorio extends JpaRepository<Movil, Long>{

	public List<Movil> findByMarcaIgnoreCase(String marca);

}
