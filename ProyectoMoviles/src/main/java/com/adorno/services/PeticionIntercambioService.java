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
	//	ObjectId idd=id;
		Optional<PeticionIntercambio> peticionIntercambio= this.peticionIntercambioRepo.findById(id);
		return false;
	}

	@Override
	public Optional<PeticionIntercambio> getById(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
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
