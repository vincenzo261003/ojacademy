package com.taskPalestra.GestionePalestra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.taskPalestra.GestionePalestra.dto.UtenteDto;
import com.taskPalestra.GestionePalestra.services.UtenteService;

@Controller
@RequestMapping("/palestra/utenti")
@EnableWebMvc
public class UtenteControllerWeb {

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
	public String allPersone(Model model){
		List<UtenteDto> elenco = service.ottieniUtenti();
		model.addAttribute("utenti", elenco);
		return "elencoUtenti";
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
