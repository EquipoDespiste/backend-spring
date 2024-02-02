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

//@Component
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
	                new Marca("Samsung"), new Pantalla(1l, 5.5f, "LCD"),
	                new Dimension(1l, 150.0f, 70.0f, 8.0f), new Procesador(6l, "Snapdragon 855", 8, 2.84f)));
		  moviles.add(new Movil("Galaxy S27", 128, 12, 160.0f, 16, 4500, true, 120, 299.99f,
				  new Marca("Samsung"), new Pantalla(1l, 5.5f, "LCD"),
				  new Dimension(2l, 160.0f, 75.0f, 9.0f), new Procesador(8l, "A14 Bionic", 6, 3.1f)));
		  moviles.add(new Movil("Galaxy S57", 128, 12, 160.0f, 16, 4500, false, 120, 299.99f,
				  new Marca("Samsung"), new Pantalla(7l, 5.9f, "LCD"),
				  new Dimension(2l, 160.0f, 75.0f, 9.0f), new Procesador(8l, "A14 Bionic", 6, 3.1f)));
		  moviles.add(new Movil("Galaxy S17", 128, 12, 160.0f, 16, 4500, false, 120, 299.99f,
				  new Marca("Samsung"), new Pantalla(4l, 6.4f, "OLED"),
				  new Dimension(3l, 155.0f, 72.0f, 7.5f), new Procesador(8l, "A14 Bionic", 6, 3.1f)));

	        moviles.add(new Movil("iPhone 13", 256, 16, 173.0f, 12, 3687, true, 90, 999.99f,
	                new Marca("Apple"), new Pantalla(6.1f, "Super Retina XDR"),
	                new Dimension(4l, 155.0f, 68.0f, 8.5f), new Procesador(1l, "Snapdragon 865", 8, 2.84f)));

	        moviles.add(new Movil("OnePlus 9", 256, 12, 183.0f, 48, 4500, true, 110, 899.99f,
	                new Marca("Samsung"), new Pantalla(8l, 6.3f, "AMOLED"),
	                new Dimension(2l, 160.0f, 75.0f, 9.0f), new Procesador(1l, "Snapdragon 865", 8, 2.84f)));

	        moviles.add(new Movil("Redmi 6", 128, 8, 183.8f, 50, 4600, true, 105, 899.99f,
	                new Marca("Xiaomi"), new Pantalla(7l, 5.9f, "LCD"),
	                new Dimension(1l, 150.0f, 70.0f, 8.0f), new Procesador(1l, "Snapdragon 865", 8, 2.84f)));
	        moviles.add(new Movil("Xperia 5 III", 128, 8, 168.0f, 12, 4500, true, 95, 899.99f,
	                new Marca("Samsung"), new Pantalla(8l, 6.3f, "AMOLED"),
	                new Dimension(1l, 150.0f, 70.0f, 8.0f), new Procesador(8l, "A14 Bionic", 6, 3.1f)));

	        moviles.add(new Movil("Mi 11", 256, 12, 196.0f, 108, 4600, true, 80, 799.99f,
	                new Marca("Xiaomi"), new Pantalla(8l, 6.3f, "AMOLED"),
	                new Dimension(4l, 155.0f, 68.0f, 8.5f), new Procesador(8l, "A14 Bionic", 6, 3.1f)));

	        moviles.add(new Movil("Galaxy Z Flip 3", 128, 8, 183.3f, 12, 3300, true, 85, 1099.99f,
	                new Marca("Samsung"), new Pantalla(7l, 5.9f, "LCD"),
	                new Dimension(4l, 155.0f, 68.0f, 8.5f), new Procesador(6l, "Snapdragon 855", 8, 2.84f)));

	        moviles.add(new Movil("Redmi Note 10", 128, 6, 178.8f, 48, 5000, true, 120, 229.99f,
	                new Marca("Xiaomi"), new Pantalla(1l, 5.5f, "LCD"),
	                new Dimension(4l, 155.0f, 68.0f, 8.5f), new Procesador(1l, "Snapdragon 865", 8, 2.84f)));
	    this.movilService.add(moviles.get(0));
		
//		this.movilService.addAll(moviles);
	}

}
