package com.adorno.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adorno.modelo.Marca;

@Repository
public interface IMarcaRepositorio extends JpaRepository<Marca, Long>{
	public Marca findByNombre(String nombre);
}
