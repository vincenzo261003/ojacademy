package com.taskPalestra.GestionePalestra.controllers;

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

import com.taskPalestra.GestionePalestra.dto.UtenteDto;
import com.taskPalestra.GestionePalestra.services.UtenteService;

@RestController
@RequestMapping("/palestra/utentiAPI")
public class UtenteController {

	@Autowired
	private UtenteService service;
	
	@PostMapping
	public UtenteDto insUtente(@RequestBody UtenteDto objStud) {
		return service.inserisciUtente(objStud);
	}
	
	@GetMapping("/{varID}")
	public UtenteDto trovaUtente(@PathVariable Integer varID) {
		if (varID == null || varID < 0)
			return null;
		
		return service.cercaUtenteId(varID);
	}
	
	@GetMapping("/all")
	public List<UtenteDto> allPersone(){
		return service.ottieniUtenti();
	}
	
	@DeleteMapping("/{varID}")
	public boolean elimUtente(@PathVariable Integer varID) {
		return service.eliminaUtenteId(varID);
	}
	
	@PutMapping("/{varID}")
	public UtenteDto modUtente(@PathVariable Integer varID, @RequestBody UtenteDto objStu) {
		if (varID == null || varID < 0)
			return null;

		return service.aggiornaUtente(varID, objStu);
	}	
	
}
