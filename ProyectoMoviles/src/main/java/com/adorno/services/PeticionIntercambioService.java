package com.adorno.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.adorno.modelo.mapper.PeticionDTOMapper;
import com.adorno.modelo.mongo.AnuncioVenta;
import com.adorno.modelo.mongo.PeticionIntercambio;
import com.adorno.modelo.sql.Marca;
import com.adorno.modelo.sqlSecurity.UserEntity;
import com.adorno.repositorio.IPeticionIntercambioRepository;
import com.adorno.repositorio.UserRepository;

@Service
public class PeticionIntercambioService  {

	private final IPeticionIntercambioRepository peticionIntercambioRepo;
	private final PeticionDTOMapper peticionDTOmapper;
	private final UserRepository userRepo;

	public PeticionIntercambioService(IPeticionIntercambioRepository peticionIntercambioRepo,
			PeticionDTOMapper peticionDTOmapper, UserRepository userRepo) {
		super();
		this.peticionIntercambioRepo = peticionIntercambioRepo;
		this.peticionDTOmapper = peticionDTOmapper;
		this.userRepo = userRepo;
	}


	public boolean add(PeticionIntercambio t) {
		return this.peticionIntercambioRepo.save(t) != null;
	}


	public boolean delete(String id) {
		ObjectId idObject = new ObjectId(id);
		Optional<PeticionIntercambio> peticionIntercambio = this.peticionIntercambioRepo.findById(idObject);

		if (peticionIntercambio.isPresent()) {
			this.peticionIntercambioRepo.delete(peticionIntercambio.get());
			return true;
		}
		return false;
	}

	
	public Optional<PeticionIntercambio> getById(String id) {
		ObjectId idObject = new ObjectId(id);
		Optional<PeticionIntercambio> peticionIntercambio = this.peticionIntercambioRepo.findById(idObject);
		Optional<PeticionIntercambio> peticion = Optional.empty();

		if (peticionIntercambio.isPresent()) {
			peticion = Optional.of(peticionIntercambio.get());
		}
		return peticion;
	}

	
	public List<PeticionIntercambio> findAll() {
		return this.peticionIntercambioRepo.findAll().stream().collect(Collectors.toList());
	}

	
	public boolean addAll(List<PeticionIntercambio> t) {
		return this.peticionIntercambioRepo.saveAll(t.stream().collect(Collectors.toList())) != null;
	}

	public List<PeticionIntercambio> getAllByUser(String username) {

		if (this.userRepo.existsByUsername(username)) {
			System.out.println(username);
			return peticionIntercambioRepo.findAllByUsername(username);

		}
		return new ArrayList<PeticionIntercambio>();

	}

}
