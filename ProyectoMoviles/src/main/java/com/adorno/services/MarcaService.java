package com.adorno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adorno.modelo.Marca;

@Service
public class MarcaService implements Services<Marca> {

	@Override
	public boolean add(Marca t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Optional<Marca> getById(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Marca> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAll(List<Marca> t) {
		// TODO Auto-generated method stub
		return false;
	}

}
