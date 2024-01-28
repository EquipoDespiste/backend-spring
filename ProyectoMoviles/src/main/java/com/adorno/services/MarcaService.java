package com.adorno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adorno.modelo.Marca;
import com.adorno.repositorio.IMarcaRepositorio;

@Service
public class MarcaService implements Services<Marca> {

	private IMarcaRepositorio marcaRepo;
	
	public MarcaService(IMarcaRepositorio marcaRepo) {
		super();
		this.marcaRepo = marcaRepo;
	}

	public MarcaService() {
		super();
	}

	@Override
	public boolean add(Marca t) {
		return this.marcaRepo.save(t) != null;
	}

	@Override
	public boolean delete(long id) {
		
		Optional<Marca> marca = this.marcaRepo.findById(id);
		
		if(marca.isPresent()) {
			this.marcaRepo.delete(marca.get());
			return true;
		}
		return false;
	}

	@Override
	public Optional<Marca> getById(long id) {
		return this.marcaRepo.findById(id);
	}

	@Override
	public List<Marca> findAll() {
		return this.marcaRepo.findAll();
	}

	@Override
	public boolean addAll(List<Marca> t) {
//		t.forEach(marca->{
//			this.marcaRepo.save(marca);
//		});
		this.marcaRepo.saveAll(t);
		return false;
	}

}
