package com.ospedale.Task03.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ospedale.Task03.models.Visita;
import com.ospedale.Task03.services.VisitaService;

@RestController
@RequestMapping("/ospedale/visite")
public class VisitaController {
	
	@Autowired
	private VisitaService service;
	
	@PostMapping
	public Visita insVisita(@RequestBody Visita objStud) {
		objStud.genCodice();
		objStud.genSecret();
		return service.inserisciVisita(objStud);
	}
	
	@GetMapping("/{varID}")
	public Visita trovaVisita(@PathVariable Integer varID) {
		if (varID == null || varID < 0)
			return null;
		
		return service.trovaVisita(varID);
	}
	
//	@GetMapping("/secret")
//	public Visita trovaVisitaSecret(@RequestParam String codice, @RequestParam String secret) {
//		return service.trovaVisitaSecret(codice, secret);
//	}
//	
//	@GetMapping("/data")
//	public List<Visita> trovaVisiteData(@RequestParam Date date) {
//		return service.trovaVisiteData(date);
//	} 
//	
//	@GetMapping("/date")
//	public List<Visita> trovaVisiteDate(@RequestParam Date startDate, @RequestParam Date endDate) {
//		return service.trovaVisiteDate(startDate, endDate);
//	}
	
//	@GetMapping({"/cf/{varCF}", "/CF/{varCF}"})
//	public List<Visita> trovaVisiteCF(@PathVariable String varCF) {
////		if (varCF.length() != 16)
////			return null;
//		
//		return service.trovaVisitaCF(varCF);
//	} 
	
	@GetMapping("/all")
	public List<Visita> allVisite(){
		return service.listaVisite();
	}
	
	@DeleteMapping("/{varID}")
	public boolean elimVisita(@PathVariable Integer varID) {
		return service.eliminaVisita(varID);
	}
	
	@PutMapping("/{varID}")
	public Visita modVisita(@PathVariable Integer varID, @RequestBody Visita objStu) {
		if (varID == null || varID < 0)
			return null;

		return service.aggiornaVisita(varID, objStu);
	}	

}
