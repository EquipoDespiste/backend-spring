package com.adorno.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorno.modelo.Marca;
import com.adorno.modelo.Movil;
import com.adorno.modelo.dto.MovilResumenDTO;
import com.adorno.modelo.mapper.MovilResumenDTOMapper;
import com.adorno.repositorio.IMarcaRepositorio;
import com.adorno.repositorio.IMovilRepositorio;

@Service

public class MovilService implements Services<Movil>{

	private final IMovilRepositorio movilRepo;
	private final IMarcaRepositorio marcaRepo;
	private final MovilResumenDTOMapper movilResumenDTOMapper;
	
	public MovilService(IMovilRepositorio movilRepo, IMarcaRepositorio marcaRepo, MovilResumenDTOMapper movilResumenDTOMapper) {
		super();
		this.movilRepo=movilRepo;
		this.marcaRepo=marcaRepo;
		this.movilResumenDTOMapper= movilResumenDTOMapper;

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
		return movilRepo.findByMarca(marcaRepo.findByNombreIgnoreCase(marca));

	}
	
	public MovilResumenDTO getByIdResumen(long id){
		return movilResumenDTOMapper.mapToDTO(getById(id).get());
	}
	
	public List<MovilResumenDTO> findAllResumen(){
		return findAll().stream().map((movil)->{
			return movilResumenDTOMapper.mapToDTO(movil);
			}).collect(Collectors.toList());
	}
}
