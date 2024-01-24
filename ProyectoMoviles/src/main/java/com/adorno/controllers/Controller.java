package com.adorno.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface Controller<T> {
	
	@GetMapping("all")
	public List<T> all();
	
	@GetMapping("busqueda/{id}")
	public T findById(@PathVariable long id);
	
	@PostMapping("insert")
	public boolean insert(@RequestBody T t);
	
	@PostMapping("insert-all")
	public boolean insertAll(@RequestBody List<T> t);
	
	@PostMapping("delete/{id}")
	public boolean delete(@PathVariable long id);
	
	

}
