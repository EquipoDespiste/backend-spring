package com.adorno.repositorio;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.adorno.modelo.mongo.AnuncioIntercambio;
import com.adorno.modelo.mongo.PeticionIntercambio;

public interface IPeticionIntercambioRepository extends MongoRepository<PeticionIntercambio, ObjectId> {

	public List<PeticionIntercambio> findAllByUsername(String username);
	
}
