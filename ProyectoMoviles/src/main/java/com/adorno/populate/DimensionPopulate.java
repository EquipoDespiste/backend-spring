package com.adorno.populate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.adorno.modelo.Dimension;
import com.adorno.services.DimensionService;

@Component
public class DimensionPopulate implements Populate{
	private final DimensionService dimensionService;
	
	public DimensionPopulate(DimensionService dimensionService) {
		super();
		this.dimensionService = dimensionService;
		initPopulate();
	}

	@Override
	public void initPopulate() {

		List<Dimension> dimensiones = new ArrayList<>();
		dimensiones.add(new Dimension(150, 70, 8));
		dimensiones.add(new Dimension(160, 75, 9));
		dimensiones.add(new Dimension(155, 72, 7.5f));
		dimensiones.add(new Dimension(155, 68, 8.5f));
		dimensiones.add(new Dimension(165, 72, 9.2f));
		dimensiones.add(new Dimension(160, 71, 8.8f));
		dimensiones.add(new Dimension(150, 65, 8.1f));
		dimensiones.add(new Dimension(170, 78, 9.5f));
		dimensiones.add(new Dimension(158, 69, 8.3f));
		dimensiones.add(new Dimension(162, 73, 8.9f));
		dimensiones.add(new Dimension(148, 67, 8.0f));
		dimensiones.add(new Dimension(175, 80, 9.8f));
		dimensiones.add(new Dimension(155, 70, 8.7f));
		
		this.dimensionService.addAll(dimensiones);
	}

}
