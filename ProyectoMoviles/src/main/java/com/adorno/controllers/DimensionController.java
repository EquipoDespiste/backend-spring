package com.adorno.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.modelo.Dimension;
import com.adorno.services.DimensionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("dimensiones")
public class DimensionController implements Controller<Dimension>{

	private final DimensionService dimensionService;

	public DimensionController(DimensionService dimensionService) {
		super();
		this.dimensionService = dimensionService;
	}
	
	@Override
	public List<Dimension> all() {
		return dimensionService.findAll();
	}
	
	@Override
	public Dimension findById(@PathVariable long id) {
		return dimensionService.getById(id).orElse(new Dimension());
	}
	
	
	@Override
	public boolean insert(@RequestBody Dimension dimension) {
		return dimensionService.add(dimension);
	}
	
	@Override
	public boolean insertAll(@RequestBody List<Dimension> dimensiones) {
		return dimensionService.addAll(dimensiones);
	}

	@Override
	public boolean delete(@PathVariable long id) {
		return dimensionService.delete(id);
	}

}
