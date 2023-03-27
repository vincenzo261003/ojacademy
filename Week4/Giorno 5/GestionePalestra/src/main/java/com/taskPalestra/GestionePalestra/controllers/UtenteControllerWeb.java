package com.taskPalestra.GestionePalestra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.taskPalestra.GestionePalestra.dto.UtenteDto;
import com.taskPalestra.GestionePalestra.models.Utente;
import com.taskPalestra.GestionePalestra.services.UtenteService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/palestra/utenti")
@EnableWebMvc
public class UtenteControllerWeb {

	@Autowired
	private UtenteService service;
	
	@PostMapping
	public String insUtente(@ModelAttribute("utente") UtenteDto objStud) {
		service.inserisciUtente(objStud);
		return "redirect:/palestra/login";
	}
	
	@GetMapping("register")
	public String inserisciStudente(Model model) {
		UtenteDto u = new UtenteDto();
		model.addAttribute("inserimento", true);
		model.addAttribute("utente", u);
		return "inserimentoutente";
	}
	
	@GetMapping("/{varID}")
	public UtenteDto trovaUtente(@PathVariable Integer varID) {
		if (varID == null || varID < 0)
			return null;
		
		return service.cercaUtenteId(varID);
	}
	
	@GetMapping("/all")
	public String allPersone(Model model, HttpServletRequest request){
		HttpSession sessione = request.getSession();
		String ruolo;
		
		try {
			ruolo = (String)sessione.getAttribute("ruolo");
		} catch (Exception e) {
			return "redirect:/palestra/login";
		}
		
		if (ruolo.equals("ADMIN")) {
			List<UtenteDto> elenco = service.ottieniUtenti();
			model.addAttribute("utenti", elenco);
			return "elencoUtenti";
		}
		
		return "error";
	}
	
	@GetMapping("/modifica/{varEmail}")
	public String modUtente(@PathVariable String varEmail, Model model){
		UtenteDto u = service.cercaUtenteEmail(varEmail);
		model.addAttribute("utente", u);
		return "dettaglioutente";
	}
	
	@GetMapping("/elimina/{varEmail}")
	public String elimUtente(@PathVariable String varEmail, HttpServletRequest request) {
		HttpSession sessione = request.getSession();
		
		String ruolo;
		
		try {
			ruolo = (String)sessione.getAttribute("ruolo");
		} catch (Exception e) {
			return "redirect:/palestra/login";
		}
		
		if (ruolo.equals("ADMIN")) {
			if (service.eliminaUtenteEmail(varEmail))
				return "redirect:/palestra/utenti/all";
		}
		
		if (ruolo.equals("USER")) {
			UtenteDto u = (UtenteDto)sessione.getAttribute("user");
			if (u.getEmail().equals(varEmail))
				if (service.eliminaUtenteEmail(varEmail))
					return "redirect:/palestra/login";
		}
		
		return "error";
	}
	
	@PutMapping("/{varID}")
	public UtenteDto modUtente(@PathVariable Integer varID, @RequestBody UtenteDto objStu) {
		if (varID == null || varID < 0)
			return null;
		return service.aggiornaUtente(varID, objStu);
	}
	
}
