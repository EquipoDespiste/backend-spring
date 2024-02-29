package com.adorno.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.services.PeticionVentaService;

@RestController
@RequestMapping("PeticionVentaController")
public class PeticionVentaController {
private final PeticionVentaService peticionVentaService;

public PeticionVentaController(PeticionVentaService peticionVentaService) {
	super();
	this.peticionVentaService = peticionVentaService;
}



}
