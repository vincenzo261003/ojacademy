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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.taskPalestra.GestionePalestra.dto.CorsoDto;
import com.taskPalestra.GestionePalestra.dto.UtenteDto;
import com.taskPalestra.GestionePalestra.services.CorsoService;

@Controller
@RequestMapping("/palestra/corsi")
@EnableWebMvc
public class CorsoControllerWeb {

	@Autowired
	private CorsoService service;
	
	@PostMapping
	public CorsoDto insCorso(@RequestBody CorsoDto objStud) {
		return service.inserisciCorso(objStud);
	}
	
	@GetMapping("/{varID}")
	public CorsoDto trovaCorso(@PathVariable Integer varID) {
		if (varID == null || varID < 0)
			return null;
		
		return service.cercaCorsoId(varID);
	}
	
	@GetMapping("/all")
	public String allPersone(Model model){
		List<CorsoDto> elenco = service.ottieniCorsi();
		model.addAttribute("corsi", elenco);
		return "elencoCorsi";
	}
	
	@DeleteMapping("/{varID}")
	public boolean elimCorso(@PathVariable Integer varID) {
		return service.eliminaCorsoId(varID);
	}
	
	@PutMapping("/{varID}")
	public CorsoDto modCorso(@PathVariable Integer varID, @RequestBody CorsoDto objStu) {
		if (varID == null || varID < 0)
			return null;

		return service.aggiornaCorso(varID, objStu);
	}	
	
}
