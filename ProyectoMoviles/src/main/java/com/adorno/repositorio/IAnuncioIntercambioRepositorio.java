package com.adorno.repositorio;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.adorno.modelo.mongo.Anuncio;
import com.adorno.modelo.mongo.AnuncioIntercambio;


public interface IAnuncioIntercambioRepositorio extends MongoRepository<AnuncioIntercambio, ObjectId> {

	public List<AnuncioIntercambio> findByVidaBateria(Float vidaBateria);
	
	// no se que mas metodos añadir mis niños
}
