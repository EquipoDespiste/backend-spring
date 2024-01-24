package com.adorno.services;

import java.util.List;
import java.util.Optional;

public interface Services<T> {
	
	public boolean add(T t);
	
	public boolean delete(long id);
	
	public Optional<T> getById(long id);
	
	public List<T> findAll();
	
	public boolean addAll(List<T> t);
	
}
