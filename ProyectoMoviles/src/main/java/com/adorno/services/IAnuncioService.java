package com.adorno.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adorno.modelo.mongo.Anuncio;

@Service
public interface IAnuncioService {

	public List<Anuncio> findByTipo();
	
	// no se que mas metodos añadir mis niños
}
