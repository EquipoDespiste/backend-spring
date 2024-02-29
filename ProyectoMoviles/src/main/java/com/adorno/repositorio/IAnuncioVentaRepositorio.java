package com.adorno.repositorio;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.adorno.modelo.mongo.AnuncioVenta;
import com.adorno.modelo.mongo.EstadoAnuncio;
public interface IAnuncioVentaRepositorio extends MongoRepository<AnuncioVenta, ObjectId> {
	
	public List<AnuncioVenta> findAllByEstadoAnuncio(EstadoAnuncio estadoAnuncio);
	public void deleteById(ObjectId id);
	public Optional<AnuncioVenta> findById(ObjectId id);
	public List<AnuncioVenta> findAllOrderByPrecio();
}
