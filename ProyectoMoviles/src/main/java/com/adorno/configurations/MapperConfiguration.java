package com.adorno.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adorno.modelo.mapper.MovilDetalladoDTOMapper;
import com.adorno.modelo.mapper.MovilResumenDTOMapper;
import com.adorno.modelo.mapper.UserMapper;

@Configuration
public class MapperConfiguration {
	
	@Bean
	public MovilResumenDTOMapper getMovilResumenDTOMapper() {
		return new MovilResumenDTOMapper();
	}
	
	@Bean 
	public MovilDetalladoDTOMapper getMovilDetalladoDTOMapper() {
		return new MovilDetalladoDTOMapper();
	}
	
	@Bean
	public UserMapper getUserMApper() {
		return new UserMapper();
	}
}
