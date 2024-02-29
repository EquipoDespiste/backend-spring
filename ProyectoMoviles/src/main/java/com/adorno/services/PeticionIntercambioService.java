package com.adorno.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.adorno.modelo.mapper.PeticionDTOMapper;
import com.adorno.modelo.mongo.PeticionIntercambio;
import com.adorno.modelo.sqlSecurity.UserEntity;
import com.adorno.repositorio.IPeticionIntercambioRepository;
@Service
public class PeticionIntercambioService implements Services<PeticionIntercambio> {

	private final IPeticionIntercambioRepository peticionIntercambioRepo;
	private final PeticionDTOMapper peticionDTOmapper;
	


	public PeticionIntercambioService(IPeticionIntercambioRepository peticionIntercambioRepo,
			PeticionDTOMapper peticionDTOmapper) {
		super();
		this.peticionIntercambioRepo = peticionIntercambioRepo;
		this.peticionDTOmapper = peticionDTOmapper;
	}

	@Override
	public boolean add(PeticionIntercambio t) {
		return this.peticionIntercambioRepo.save(t)!=null;
	}

	@Override
	public boolean delete(long id) {
		String idd=String.valueOf(id);
		ObjectId idObject= new ObjectId(idd);
		Optional<PeticionIntercambio> peticionIntercambio= this.peticionIntercambioRepo.findById(idObject);
	
		if(peticionIntercambio.isPresent()) {
			this.peticionIntercambioRepo.delete(peticionIntercambio.get());
			return true;
		}
		return false;
	}

	@Override
	public Optional<PeticionIntercambio> getById(long id) {
		String idd=String.valueOf(id);
		ObjectId idObject= new ObjectId(idd);
		Optional<PeticionIntercambio> peticionIntercambio= this.peticionIntercambioRepo.findById(idObject);
		Optional<PeticionIntercambio>peticion=Optional.empty();
		
		if(peticionIntercambio.isPresent()) {
			peticion = Optional.of(peticionIntercambio.get());	
		}
		return peticion;
	}

	@Override
	public List<PeticionIntercambio> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAll(List<PeticionIntercambio> t) {
		// TODO Auto-generated method stub
		return false;
	}

	public Optional<PeticionIntercambio> findByPeticionUser(UserEntity user){
		
		
		return null;
		
	}


}
