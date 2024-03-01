package com.adorno.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.adorno.modelo.mongo.PeticionIntercambio;
import com.adorno.modelo.mongo.PeticionVenta;
import com.adorno.repositorio.IAnuncioVentaRepositorio;
import com.adorno.repositorio.IPeticionVentaRepository;
import com.adorno.repositorio.UserRepository;

@Service
public class PeticionVentaService {

	private final IPeticionVentaRepository peticionVentarepo;
	private final UserRepository userRepository;
	private final AnuncioVentaService anuncioVentaService;

	public PeticionVentaService(IPeticionVentaRepository peticionVentarepo, UserRepository userRepository, AnuncioVentaService anuncioVentaService) {
		super();
		this.peticionVentarepo = peticionVentarepo;
		this.userRepository = userRepository;
		this.anuncioVentaService=anuncioVentaService;
	}

	public boolean add(PeticionVenta t) {
		
		boolean retorno =this.peticionVentarepo.save(t) != null;
//		anuncioVentaService.addPeticion(t);
		return retorno;
	}

	public boolean delete(String id) {
		ObjectId idObject = new ObjectId(id);
		Optional<PeticionVenta> petii = this.peticionVentarepo.findById(idObject);

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

	public List<PeticionVenta> getAllByUser(String username) {
		if (this.userRepository.existsByUsername(username)) {
			System.out.println(username);
			return peticionVentarepo.findAllByUsername(username);

		}
		return new ArrayList<PeticionVenta>();

	}
}
