package com.taskCondominio.Gestione.condomini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.taskCondominio.Gestione.condomini.dto.CondominioDto;
import com.taskCondominio.Gestione.condomini.dto.UtenteDto;
import com.taskCondominio.Gestione.condomini.services.CondominioService;
import com.taskCondominio.Gestione.condomini.services.UtenteService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/condomini/utenti")
@EnableWebMvc
public class UtenteControllerWeb {
	
	@Autowired
	private UtenteService service;
	
	@Autowired
	private CondominioService service2;

	@GetMapping("/aggiungi/{varCondominio}")
	public String inserisciInquilino(@PathVariable String varCondominio, Model model, HttpServletRequest request) {
		if (! checkAutenticazione(request, 1))
			return "errorPermessi";
		
		UtenteDto u = new UtenteDto();
		model.addAttribute("utente", u);
		model.addAttribute("condominio", varCondominio);
		
		return "inserimentoInquilino";
	}
	
	@PostMapping("/aggiungi/{varCondominio}")
	public String insUtente(@ModelAttribute("utente") UtenteDto objUser, @PathVariable String varCondominio) {
		service.inserisciUtente2(objUser, service2.cercaCondominioCodice2(varCondominio));
		return "redirect:/condomini/stabile/" + varCondominio;
	}
	
	@GetMapping("/elimina/{varAppartamento}")
	public String eliminaInquilino(@PathVariable String varAppartamento, HttpServletRequest request) {
		if (! checkAutenticazione(request, 1))
			return "errorPermessi";
		
		String varCondominio = service.cercaUtenteUsername(varAppartamento).getCondominio().getCodice();
		
		if (! service.eliminaUtenteCodice(varAppartamento))
			return "error";
		
		return "redirect:/condomini/stabile/" + varCondominio;
	}
	
	@GetMapping("/modifica/{varAppartamento}")
	public String modInquilino(@PathVariable String varAppartamento, HttpServletRequest request, Model model) {
		if (! checkAutenticazione(request, 1))
			return "errorPermessi";
		model.addAttribute("utente", service.cercaUtenteUsername(varAppartamento));

		return "modificaInquilino";
	}
	
	@PostMapping("/modifica/{varAppartamento}")
	public String savInquilino(@ModelAttribute("utente") UtenteDto u, @PathVariable String varAppartamento) {
		String varCondominio = service.cercaUtenteUsername(varAppartamento).getCondominio().getCodice();
		service.aggiornaUtente(u);
		
		return "redirect:/condomini/stabile/" + varCondominio;
	}
	
	public boolean checkAutenticazione(HttpServletRequest req, int livello) {
		HttpSession sessione = req.getSession();
		
		//Get utente check sessione
		UtenteDto user = null;
		try {
			user = (UtenteDto)sessione.getAttribute("user");
		} catch (Exception e) {
			return false;
		}
		
		//Return in base al livello richiesto
		switch (livello) {
			case 0:
				return true;
			case 1: 
				if (user != null && user.isIsadmin())
					return true;
				else 
					return false;
		}
		
		//Errore?
		return false;
	}
	
}
