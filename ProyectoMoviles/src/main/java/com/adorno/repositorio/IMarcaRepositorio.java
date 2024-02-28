package com.adorno.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adorno.modelo.sql.Marca;

@Repository
public interface IMarcaRepositorio extends JpaRepository<Marca, Long>{
	public Marca findByNombreIgnoreCase(String nombre);
}
