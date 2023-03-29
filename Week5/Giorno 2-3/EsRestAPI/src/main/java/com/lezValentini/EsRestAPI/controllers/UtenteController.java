package com.lezValentini.EsRestAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lezValentini.EsRestAPI.dto.UtenteDto;
import com.lezValentini.EsRestAPI.services.UtenteService;

@RestController
@RequestMapping("utenti")
public class UtenteController {
	
	@Autowired
	private UtenteService service;
	
	@GetMapping("/cerca/{varID}")
	public UtenteDto getUtente(@PathVariable String varID){
		return service.cercaId(varID);
	}
	
	@PostMapping("/inserisci")
	public String insertUtente(@RequestBody UtenteDto u) {
		return service.inserisci(u);
	}

}
