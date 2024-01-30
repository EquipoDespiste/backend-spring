package com.adorno.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adorno.modelo.mapper.MovilResumenDTOMapper;

@Configuration
public class MapperConfiguration {
	
	@Bean
	public MovilResumenDTOMapper getMovilResumenDTOMapper() {
		return new MovilResumenDTOMapper();
	}

}
