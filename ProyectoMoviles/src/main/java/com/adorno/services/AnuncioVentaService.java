package com.adorno.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.adorno.modelo.mongo.AnuncioIntercambio;
import com.adorno.modelo.mongo.AnuncioVenta;
import com.adorno.modelo.mongo.EstadoAnuncio;
import com.adorno.modelo.mongo.PeticionVenta;
import com.adorno.repositorio.IAnuncioVentaRepositorio;
import com.adorno.repositorio.UserRepository;

@Service
public class AnuncioVentaService {

	private final IAnuncioVentaRepositorio anuncioVentaRepositorio;
	private final UserRepository userRepo;

	public AnuncioVentaService(IAnuncioVentaRepositorio anuncioVentaRepositorio, UserRepository userRepo) {
		super();
		this.anuncioVentaRepositorio = anuncioVentaRepositorio;
		this.userRepo=userRepo;
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
	
	public List<AnuncioVenta> findAllEstadoAnuncio(EstadoAnuncio estadoAnuncio){
		return anuncioVentaRepositorio.findAllByEstadoAnuncio(estadoAnuncio);
		
	}
	
	public List<AnuncioVenta> getAllByUsername(String username) {
		if (this.userRepo.existsByUsername(username)) {
			System.out.println(username);
			return anuncioVentaRepositorio.findAllByUsername(username);
			
	}
		return new ArrayList<AnuncioVenta>();
		
	}


	public void addPeticion(PeticionVenta t) {
		AnuncioVenta anuncio = anuncioVentaRepositorio.findById(t.getId()).get();
		anuncio.addPeticion(t);
	}

	
	
	
	
}
