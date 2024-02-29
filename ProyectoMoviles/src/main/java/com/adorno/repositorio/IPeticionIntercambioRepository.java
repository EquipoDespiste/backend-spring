package com.adorno.repositorio;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.adorno.modelo.mongo.PeticionIntercambio;

public interface IPeticionIntercambioRepository extends MongoRepository<PeticionIntercambio, ObjectId> {

//	public boolean guardarSolicitud(Peticion p);
//	//el parametro del tipo no lo sabemos aun, hace falta insetar
//	public List<Peticion> consultarPorTipo();
//	public List<Peticion>consultarPorFechas(LocalDate fechaInicial, LocalDate fechaFinal);
//	//el otro enum de estado ,pal parametro
//	public List<Peticion>consultarEstado();
//	public List<Peticion> consultarPeticionesContestadas();
//	public List<Peticion> consultarPeticionesNoContestadas();
	
}
