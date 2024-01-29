package com.adorno.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorno.modelo.Marca;
import com.adorno.modelo.Movil;
import com.adorno.repositorio.IMarcaRepositorio;
import com.adorno.repositorio.IMovilRepositorio;

@Service
public class MovilService implements Services<Movil> {
	@Autowired
	private IMovilRepositorio movilRepo;
	@Autowired
	private MarcaService marcaService;

	public MovilService() {
		super();

	}

	@Override
	public boolean add(Movil movil) {
		return movilRepo.save(movil) != null;
	}

	@Override
	public boolean delete(long id) {
		boolean retorno = movilRepo.findById(id).isPresent();
		if (retorno) {
			movilRepo.findById(id).ifPresent((movil) -> {
				movilRepo.delete(movil);
			});
		}

		return retorno;
	}

	@Override
	public Optional<Movil> getById(long id) {
		return movilRepo.findById(id);
	}

	@Override
	public List<Movil> findAll() {
		return movilRepo.findAll();
	}

	@Override
	// devuelvo true porque funciona y porque no hay otro metodo
	public boolean addAll(List<Movil> moviles) {
		moviles.stream().forEach((movil) -> {
			movilRepo.save(movil);
		});
		return true;
	}

	public List<Movil> findByMarca(String marca) { 
		return movilRepo.findByMarcaIgnoreCase(marcaService.getMarcaByNombre(marca));

	}

}
