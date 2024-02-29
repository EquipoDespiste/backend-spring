package com.adorno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adorno.modelo.mongo.PeticionIntercambio;
import com.adorno.modelo.sqlSecurity.UserEntity;
@Service
public class PeticionIntercambioService implements Services<PeticionIntercambio> {

	@Override
	public boolean add(PeticionIntercambio t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
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
