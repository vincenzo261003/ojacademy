package com.task00.task00ThymeLeaf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.task00.task00ThymeLeaf.models.Studente;
import com.task00.task00ThymeLeaf.services.StudenteService;

@Controller
@RequestMapping("studenti")
@EnableWebMvc
public class StudenteController {
	
	@Autowired
	StudenteService service;
	
	@GetMapping("all")
	public String elencoStudenti(Model model){
		List<Studente> elenco = service.listaStudenti();
		model.addAttribute("elenco", elenco);
		return "elencoStudenti";
	}
	
	@GetMapping("cerca")
	public String showCercaStudente(Model model){
		Studente stud = new Studente();
		model.addAttribute("stud", stud);
		return "nuovaRicerca";
	}
	
	@PostMapping("cercaPerMatricola")
	public String cercaStudente(@ModelAttribute("stud") Studente s, Model model){
		Studente x = service.trovaStudenteMatricola(s.getMatricola());
		model.addAttribute("stud", x);
		return "ricercaEffettuata";
	}
	
}
