package com.adorno.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.adorno.modelo.mongo.PeticionVenta;
import com.adorno.repositorio.IPeticionVentaRepository;

@Service
public class PeticionVentaService {

	private final IPeticionVentaRepository peticionVentarepo;

	public PeticionVentaService(IPeticionVentaRepository peticionVentarepo) {
		super();
		this.peticionVentarepo = peticionVentarepo;
	}



	public boolean add(PeticionVenta t) {
		return this.peticionVentarepo.save(t) != null;
	}

	public boolean delete(ObjectId id) {
		Optional<PeticionVenta> petii = this.peticionVentarepo.findById(id);
		
		if (petii.isPresent()) {
			this.peticionVentarepo.delete(petii.get());
			return true;
		}
		return false;
	}

	
	public Optional<PeticionVenta> getById(ObjectId id) {
		return peticionVentarepo.findById(id);
	}

	
	public List<PeticionVenta> findAll() {
		return this.peticionVentarepo.findAll();
	}

	
	public boolean addAll(List<PeticionVenta> t) {
		 t.stream().forEach((anuncio) -> {
            if (!peticionVentarepo.findAll().contains(anuncio))
                peticionVentarepo.save(anuncio);
        });
		 return true;
	}

}
