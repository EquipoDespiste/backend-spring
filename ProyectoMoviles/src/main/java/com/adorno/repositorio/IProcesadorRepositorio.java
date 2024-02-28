package com.adorno.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adorno.modelo.sql.Marca;
import com.adorno.modelo.sql.Procesador;
@Repository
public interface IProcesadorRepositorio extends JpaRepository<Procesador, Long>{

	public Procesador findByTipoIgnoreCase(String nombre);
//	public List<Procesador> findByNucleosGreaterThanEqual(int cantidad);
//	public List<Procesador> findByVelocidad_maxGreaterThanEqual(int cantidad);
}
