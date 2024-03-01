package com.adorno.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.adorno.modelo.mongo.AnuncioIntercambio;
import com.adorno.modelo.mongo.PeticionVenta;
import com.adorno.repositorio.IAnuncioIntercambioRepositorio;
import com.adorno.repositorio.UserRepository;

@Service
public class AnuncioIntercambioService {

	private final IAnuncioIntercambioRepositorio anuncioIntercambioRepo;
	private final UserRepository userRepo;

	
	public AnuncioIntercambioService(IAnuncioIntercambioRepositorio anuncioIntercambioRepo, UserRepository userRepo) {
		super();
		this.anuncioIntercambioRepo = anuncioIntercambioRepo;
		this.userRepo=userRepo;
	}

	
	public boolean add(AnuncioIntercambio t) {
		return this.anuncioIntercambioRepo.save(t) != null;
	}

	public boolean delete(ObjectId id) {
		Optional<AnuncioIntercambio> anuncioI = this.anuncioIntercambioRepo.findById(id);
		
		if (anuncioI.isPresent()) {
			this.anuncioIntercambioRepo.delete(anuncioI.get());
			return true;
		}
		return false;
	}

	
	public Optional<AnuncioIntercambio> getById(ObjectId id) {
		return anuncioIntercambioRepo.findById(id);
	}

	
	public List<AnuncioIntercambio> findAll() {
		return this.anuncioIntercambioRepo.findAll();
	}

	
	public boolean addAll(List<AnuncioIntercambio> t) {
		 t.stream().forEach((anuncio) -> {
            if (!anuncioIntercambioRepo.findAll().contains(anuncio))
                anuncioIntercambioRepo.save(anuncio);
        });
		 return true;
	}
	
	public List<AnuncioIntercambio> getAllByUsername(String username) {
		if (this.userRepo.existsByUsername(username)) {
			System.out.println(username);
			return anuncioIntercambioRepo.findAllByUsername(username);
			
	}
		return new ArrayList<AnuncioIntercambio>();
		
	}

}
