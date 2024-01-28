package com.adorno.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.modelo.Marca;

@RestController
@RequestMapping("marca")
public class MarcaController implements Controller<Marca> {

	@Override
	public List<Marca> all() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marca findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Marca t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertAll(List<Marca> t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
