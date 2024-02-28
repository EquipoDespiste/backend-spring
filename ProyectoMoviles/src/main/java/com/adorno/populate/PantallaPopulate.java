package com.adorno.populate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.adorno.modelo.sql.Pantalla;
import com.adorno.services.PantallaService;
//@Component
public class PantallaPopulate implements Populate{
	private final PantallaService pantallaService ;

	public PantallaPopulate(PantallaService pantallaService) {
		super();
		this.pantallaService = pantallaService;
		initPopulate();
	}

	@Override
	public void initPopulate() {
		
		List<Pantalla> pantallas = new ArrayList<>();
		pantallas.add(new Pantalla(5.5f,"LCD"));
		pantallas.add(new Pantalla(6.0f,"AMOLED"));
		pantallas.add(new Pantalla(5.8f,"IPS"));
		pantallas.add(new Pantalla(6.4f,"OLED"));
		pantallas.add(new Pantalla(5.7f,"Super AMOLED"));
		pantallas.add(new Pantalla(6.2f,"Retina"));
		pantallas.add(new Pantalla(5.9f,"LCD"));
		pantallas.add(new Pantalla(6.3f,"AMOLED"));
		pantallas.add(new Pantalla(5.6f,"IPS"));
		pantallas.add(new Pantalla(6.1f,"OLED"));
		
		this.pantallaService.addAll(pantallas);
	}
	
	
	
}
