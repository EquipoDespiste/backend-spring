package com.adorno.repositorio;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.adorno.modelo.mongo.PeticionVenta;
@Repository
public interface IPeticionVentaRepository extends MongoRepository<PeticionVenta, ObjectId> {

	
	
}
