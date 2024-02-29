package com.adorno.repositorio;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.adorno.modelo.mongo.Anuncio;
import com.adorno.modelo.mongo.AnuncioIntercambio;
import com.adorno.modelo.mongo.EstadoAnuncio;


public interface IAnuncioIntercambioRepositorio extends MongoRepository<AnuncioIntercambio, ObjectId> {

	public List<AnuncioIntercambio> findByVidaBateria(Float vidaBateria);
	// no se que mas metodos añadir mis niños
	//public List<AnuncioIntercambio> findByEstadoAnuncio(EstadoAnuncio estadoAnuncio);
}
