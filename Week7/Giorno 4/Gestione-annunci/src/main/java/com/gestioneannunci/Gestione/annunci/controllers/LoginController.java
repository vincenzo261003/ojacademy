package com.gestioneannunci.Gestione.annunci.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestioneannunci.Gestione.annunci.dto.UtenteDto;
import com.gestioneannunci.Gestione.annunci.services.UtenteService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UtenteService service;
	
	@PostMapping
	public UtenteDto effettuaLogin(@RequestBody UtenteDto objUser) {
		return service.cercaUtenteUserPass(objUser);
	}
	
	@PostMapping("/new")
	public UtenteDto effettuaRegistrazione(@RequestBody UtenteDto objUser) {
		return service.inserisciUtente(objUser);
	}
	
	

}
