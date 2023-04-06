package com.coffee.ListaCaffe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.ListaCaffe.dto.StudenteDto;
import com.coffee.ListaCaffe.services.StudenteService;

@RestController
@RequestMapping("/caffe")
@CrossOrigin("*")
public class StudenteController {
	
	@Autowired
	private StudenteService service;
	
	@PostMapping
	public boolean insStudente(@RequestBody StudenteDto objStud) {
		objStud.setCaffe(0);
		objStud.setMoltiplicatori(0);
		return service.inserisciStudente(objStud);
	}
	
	@GetMapping("/{varCodice}")
	public StudenteDto trovaStudente(@PathVariable String varCodice) {		
		return service.cercaStudenteCodice(varCodice);
	}

	@GetMapping("/all")
	public List<StudenteDto> allStudenti(){
		return service.ottieniStudenti();
	}
	
	@DeleteMapping("/{varCodice}")
	public boolean elimStudente(@PathVariable String varCodice) {
		return service.eliminaStudenteCodice(varCodice);
	}
	
	@PutMapping("/{varCodice}")
	public boolean modStudente(@PathVariable String varCodice, @RequestBody StudenteDto objStu) {
		return service.aggiornaStudenteCodice(varCodice, objStu);
	}	
	
	@PatchMapping("/c/{varCodice}")
	public boolean editCaffe(@PathVariable String varCodice, @RequestParam String azione) {
		if (azione.equals("add"))
			return service.aggiungiCaffe(varCodice);
		
		if (azione.equals("-"))
			return service.rimuoviCaffe(varCodice);
		
		return false;
	}
	
	@PatchMapping("/m/{varCodice}")
	public boolean editMoltiplicatori(@PathVariable String varCodice, @RequestParam String azione) {
		if (azione.equals("add"))
			return service.aggiungiMolt(varCodice);
		
		if (azione.equals("-"))
			return service.rimuoviMolt(varCodice);
		
		return false;
	}
}
