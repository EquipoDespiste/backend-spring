package com.adorno.populate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.adorno.modelo.Marca;
import com.adorno.modelo.Movil;
import com.adorno.modelo.Pantalla;
import com.adorno.modelo.Procesador;
import com.adorno.modelo.Dimension;
import com.adorno.services.MovilService;

@Component
public class MovilPopulate implements Populate{
private final MovilService movilService;

	public MovilPopulate(MovilService movilService) {
	super();
	this.movilService = movilService;
	initPopulate();
}

	@Override
	public void initPopulate() {
		List<Movil> moviles = new ArrayList<>();		
		  moviles.add(new Movil("Galaxy S21", 128, 12, 160.0f, 16, 4500, true, 120, 799.99f,
	                new Marca("Samsung"), new Pantalla(6.2f, "Dynamic AMOLED"),
	                new Dimension(151.7f, 71.2f, 7.9f), new Procesador("Exynos 2100", 8, 2.9f)));

	        moviles.add(new Movil("iPhone 13", 256, 16, 173.0f, 12, 3687, true, 90, 999.99f,
	                new Marca("Apple"), new Pantalla(6.1f, "Super Retina XDR"),
	                new Dimension(146.7f, 71.5f, 7.7f), new Procesador("A15 Bionic", 6, 3.23f)));

	        moviles.add(new Movil("OnePlus 9", 256, 12, 183.0f, 48, 4500, true, 110, 899.99f,
	                new Marca("OnePlus"), new Pantalla(6.55f, "Fluid AMOLED"),
	                new Dimension(160.0f, 74.2f, 8.7f), new Procesador("Snapdragon 888", 8, 2.84f)));

	        moviles.add(new Movil("Pixel 6", 128, 8, 183.8f, 50, 4600, true, 105, 899.99f,
	                new Marca("Google"), new Pantalla(6.4f, "OLED"),
	                new Dimension(158.6f, 74.8f, 8.9f), new Procesador("Tensor", 8, 2.8f)));
	        moviles.add(new Movil("Xperia 5 III", 128, 8, 168.0f, 12, 4500, true, 95, 899.99f,
	                new Marca("Sony"), new Pantalla(6.1f, "OLED"),
	                new Dimension(157.0f, 68.0f, 8.2f), new Procesador("Snapdragon 888", 8, 2.84f)));

	        moviles.add(new Movil("Mi 11", 256, 12, 196.0f, 108, 4600, true, 80, 799.99f,
	                new Marca("Xiaomi"), new Pantalla(6.81f, "AMOLED"),
	                new Dimension(164.3f, 74.6f, 8.1f), new Procesador("Snapdragon 888", 8, 2.84f)));

	        moviles.add(new Movil("Galaxy Z Flip 3", 128, 8, 183.3f, 12, 3300, true, 85, 1099.99f,
	                new Marca("Samsung"), new Pantalla(6.7f, "Dynamic AMOLED"),
	                new Dimension(166.0f, 72.2f, 6.9f), new Procesador("Snapdragon 888", 8, 2.84f)));

	        moviles.add(new Movil("Redmi Note 10", 128, 6, 178.8f, 48, 5000, true, 120, 229.99f,
	                new Marca("Xiaomi"), new Pantalla(6.43f, "Super AMOLED"),
	                new Dimension(160.5f, 74.5f, 8.3f), new Procesador("Snapdragon 678", 8, 2.2f)));

		
		this.movilService.addAll(moviles);
	}

}
