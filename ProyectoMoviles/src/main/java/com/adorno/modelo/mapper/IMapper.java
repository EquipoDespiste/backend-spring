package com.adorno.modelo.mapper;

public interface IMapper<T,K> {
	T mapToDTO(K k);
	K mapToEntity(T t);
}
