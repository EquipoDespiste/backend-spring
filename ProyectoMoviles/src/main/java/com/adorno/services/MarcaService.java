package com.adorno.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorno.modelo.Marca;
import com.adorno.repositorio.IMarcaRepositorio;

@Service
public class MarcaService implements Services<String> {

	private final IMarcaRepositorio marcaRepo;
	
	public MarcaService(IMarcaRepositorio marcaRepo) {
		super();
		this.marcaRepo = marcaRepo;
	}

	@Override
	public boolean add(String t) {
		return this.marcaRepo.save(new Marca(t)) != null;
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
	public Optional<String> getById(long id) {
		Optional<String> nombreMarca=Optional.of("");
		Optional<Marca> marca = this.marcaRepo.findById(id);
		if(marca.isPresent()) {
			nombreMarca = Optional.of(marca.get().getNombre());	
		}
		return nombreMarca;
	}

	@Override
	public List<String> findAll() {
		return this.marcaRepo.findAll().stream()
				.map(marca-> marca.getNombre())
				.collect(Collectors.toList());
	}

	@Override
	public boolean addAll(List<String> t) {
//		t.forEach(marca->{
//			this.marcaRepo.save(marca);
//		});
		
		
		return this.marcaRepo.saveAll(t.stream()
								.map(nombre -> new Marca(nombre))
								.collect(Collectors.toList())) != null;
	}

	public Marca getMarcaByNombre(String marca) {
		
		return marcaRepo.findAll().stream()
				.filter((m)->{
					return m.getNombre().equalsIgnoreCase(marca);
				}).findFirst().orElse(new Marca("marca"));
	}

}
