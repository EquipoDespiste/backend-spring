package com.adorno.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.adorno.modelo.mongo.AnuncioVenta;
import com.adorno.repositorio.IAnuncioVentaRepositorio;

@Service
public class AnuncioVentaService {

	private final IAnuncioVentaRepositorio anuncioVentaRepositorio;

	public AnuncioVentaService(IAnuncioVentaRepositorio anuncioVentaRepositorio) {
		super();
		this.anuncioVentaRepositorio = anuncioVentaRepositorio;
	}

	
	public boolean add(AnuncioVenta t) {
		return this.anuncioVentaRepositorio.save(t) != null;
	}

	
	public boolean delete(ObjectId id) {
		Optional<AnuncioVenta> anuncioV = this.anuncioVentaRepositorio.findById(id);
		
		if (anuncioV.isPresent()) {
			this.anuncioVentaRepositorio.delete(anuncioV.get());
			return true;
		}
		return false;
	}

	
	public Optional<AnuncioVenta> getById(ObjectId id) {
		return anuncioVentaRepositorio.findById(id);
	}

	
	public List<AnuncioVenta> findAll() {
		return this.anuncioVentaRepositorio.findAll();
	}

	
	public boolean addAll(List<AnuncioVenta> t) {
		t.stream().forEach((anuncio) -> {
            if (!anuncioVentaRepositorio.findAll().contains(anuncio))
            	anuncioVentaRepositorio.save(anuncio);
        });
		return true;
	}
	
	
}
