package com.adorno.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.adorno.modelo.mongo.PeticionIntercambio;
import com.adorno.modelo.mongo.PeticionVenta;
import com.adorno.modelo.sqlSecurity.UserEntity;
import com.adorno.repositorio.IPeticionVentaRepository;
import com.adorno.repositorio.UserRepository;

@Service
public class PeticionVentaService {

	private final IPeticionVentaRepository peticionVentarepo;
	private final UserRepository userRepository;
	
	
	public PeticionVentaService(IPeticionVentaRepository peticionVentarepo, UserRepository userRepository) {
		super();
		this.peticionVentarepo = peticionVentarepo;
		this.userRepository = userRepository;
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



	
	public Optional<List<PeticionVenta>> findByPeticionUser(UserEntity user){
		Optional<UserEntity> usuario=this.userRepository.findByUsername(user.getUsername());
		if(usuario.isPresent()) {
			return  Optional.of( peticionVentarepo.findAll()
					.stream().filter(peti->peti.getUsuarios().equals(user.getUsername()))
					.collect(Collectors.toList()));
		}
		return Optional.ofNullable(null);
		
	}
	
	


}
