package com.adorno.populate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.adorno.modelo.sql.Procesador;
import com.adorno.services.ProcesadorService;
//@Component
public class ProcesadorPopulate implements Populate {

	private final ProcesadorService procesadorService;
	
	public ProcesadorPopulate(ProcesadorService procesadorService) {
		super();
		this.procesadorService = procesadorService;
		initPopulate();
	}

	@Override
	public void initPopulate() {
		List<Procesador> procesadores= new ArrayList<>();
		procesadores.add(new Procesador("Snapdragon 865", 8, 2.84f));
		procesadores.add(new Procesador("Exynos 990", 8, 2.73f));
		procesadores.add(new Procesador("A13 Bionic", 6, 2.66f));
		procesadores.add(new Procesador("Kirin 990", 8, 2.86f));
		procesadores.add(new Procesador("Dimensity 1000", 8, 2.6f));
		procesadores.add(new Procesador("Snapdragon 855", 8, 2.84f));
		procesadores.add(new Procesador("Exynos 9820", 8, 2.73f));
		procesadores.add(new Procesador("A14 Bionic", 6, 3.1f));
		procesadores.add(new Procesador("Kirin 980", 8, 2.6f));
		procesadores.add(new Procesador("Dimensity 800", 8, 2.0f));
		
		this.procesadorService.addAll(procesadores);
		
	}

}
