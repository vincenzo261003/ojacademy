package com.gestioneannunci.Gestione.annunci.controllers;

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

import com.gestioneannunci.Gestione.annunci.dto.AnnuncioDto;
import com.gestioneannunci.Gestione.annunci.services.AnnuncioService;


@RestController
@RequestMapping("/annunci")
public class AnnuncioController {

	@Autowired
	private AnnuncioService service;
	
	@PostMapping
	public AnnuncioDto insAnnuncio(@RequestBody AnnuncioDto objStud) {
		return service.inserisciAnnuncio(objStud);
	}
	
	@GetMapping("/{varID}")
	public AnnuncioDto trovaAnnuncio(@PathVariable String varCod) {
		if (varCod.isEmpty())
			return null;
		
		return service.cercaAnnuncioCodice(varCod);
	} 
	
	@GetMapping("/all")
	public List<AnnuncioDto> allStudenti(){
		return service.ottieniAnnunci();
	}
	
	@DeleteMapping("/{varID}")
	public boolean elimAnnuncio(@PathVariable String varCod) {
		return service.eliminaAnnuncioCodice(varCod);
	}
	
	@PutMapping("/{varID}")
	public AnnuncioDto modAnnuncio(@PathVariable String varCod, @RequestBody AnnuncioDto objStu) {
		if (varCod.isEmpty())
			return null;

		return service.aggiornaAnnuncio(varCod, objStu);
	}	
	
}
