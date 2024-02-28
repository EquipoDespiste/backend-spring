package com.adorno.services;

import java.time.LocalDate;
import java.util.List;

import com.adorno.modelo.mongo.Peticion;

public interface IPeticion {

	public boolean guardarSolicitud(Peticion p);
	//el parametro del tipo no lo sabemos aun, hace falta insetar
	public List<Peticion> consultarPorTipo();
	public List<Peticion>consultarPorFechas(LocalDate fechaInicial, LocalDate fechaFinal);
	//el otro enum de estado ,pal parametro
	public List<Peticion>consultarEstado();
	public List<Peticion> consultarPeticionesContestadas();
	public List<Peticion> consultarPeticionesNoContestadas();
	
}
