package com.ospedale.Task03.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ospedale.Task03.dto.PersonaDto;
import com.ospedale.Task03.models.Persona;
import com.ospedale.Task03.services.PersonaService;

@RestController
@RequestMapping("/ospedale/persone")
public class PersonaController {

	@Autowired
	private PersonaService service;
	
	@PostMapping
	public PersonaDto insPersona(@RequestBody PersonaDto objStud) {
		return service.inserisciPersona(objStud);
	}
	
	@GetMapping("/{varID}")
	public PersonaDto trovaPersona(@PathVariable Integer varID) {
		if (varID == null || varID < 0)
			return null;
		
		return service.trovaPersona(varID);
	}

	@GetMapping("/all")
	public List<PersonaDto> allPersone(){
		return service.listaPersone();
	}
	
	@DeleteMapping("/{varID}")
	public boolean elimPersona(@PathVariable Integer varID) {
		return service.eliminaPersona(varID);
	}
	
	@PutMapping("/{varID}")
	public PersonaDto modPersona(@PathVariable Integer varID, @RequestBody PersonaDto objStu) {
		if (varID == null || varID < 0)
			return null;

		return service.aggiornaPersona(varID, objStu);
	}	
	
}
