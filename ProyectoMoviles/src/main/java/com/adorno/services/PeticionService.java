package com.adorno.services;

import java.time.LocalDate;
import java.util.List;

import com.adorno.modelo.mongo.Peticion;

public class PeticionService implements IPeticion {

	@Override
	public boolean guardarSolicitud(Peticion p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Peticion> consultarPorTipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Peticion> consultarPorFechas(LocalDate fechaInicial, LocalDate fechaFinal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Peticion> consultarEstado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Peticion> consultarPeticionesContestadas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Peticion> consultarPeticionesNoContestadas() {
		// TODO Auto-generated method stub
		return null;
	}

}
