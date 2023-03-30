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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/condomini/stabile")
@EnableWebMvc
public class CondominioControllerWeb {
	
	@Autowired
	private CondominioService service;

	@GetMapping("/{varCondominio}")
	public String modUtente(@PathVariable String varCondominio, Model model, HttpServletRequest request){	
		if(! checkAutenticazione(request, varCondominio))
			return "errorPermessi";
		
		HttpSession sessione = request.getSession();
		UtenteDto utente = (UtenteDto)sessione.getAttribute("user");
		CondominioDto c = service.cercaCondominioCodice(varCondominio);
		
		model.addAttribute("condominio", c);
		model.addAttribute("admin", utente.isIsadmin());
		
		return "dashboardCondominio";
	}
	
	@GetMapping("/aggiungi")
	public String aggCondominio(Model model, HttpServletRequest request){	
		if(! checkAutenticazione2(request, 1))
			return "errorPermessi";
		
		CondominioDto c = new CondominioDto();
		model.addAttribute("condominio", c);
		
		return "inserimentoCondominio";
	}
	
	@PostMapping("/aggiungi")
	public String salvaCondominio(@ModelAttribute("condominio") CondominioDto objCon){	
		service.inserisciCondominio(objCon);
		return "dashboardCondominio";
	}
	
	@GetMapping("/modifica/{varCondominio}")
	public String modInquilino(@PathVariable String varCondominio, HttpServletRequest request, Model model) {
		if (! checkAutenticazione2(request, 1))
			return "errorPermessi";
		model.addAttribute("condominio", service.cercaCondominioCodice(varCondominio));

		return "modificaCondominio";
	}
	
	@PostMapping("/modifica/{varCondominio}")
	public String savInquilino(@ModelAttribute("condominio") CondominioDto u, @PathVariable String varCondominio) {
		service.aggiornaCondominio(u);
		return "redirect:/condomini/dashboard";
	}
	
	@GetMapping("/elimina/{varCodice}")
	public String delCondominio(HttpServletRequest request, @PathVariable String varCodice){	
		if(! checkAutenticazione2(request, 1))
			return "errorPermessi";
		if (! service.eliminaCondominioCodice(varCodice))
			return "error";
		return "redirect:/condomini/dashboard";
	}
	
	public boolean checkAutenticazione(HttpServletRequest req, String codice) {
		HttpSession sessione = req.getSession();
		
		//Get utente check sessione
		UtenteDto user = null;
		try {
			user = (UtenteDto)sessione.getAttribute("user");
		} catch (Exception e) {
			return false;
		}
		
		if(user != null && (user.getCondominio().getCodice().equals(codice) || user.isIsadmin()))
			return true;
		
		//Errore?
		return false;
	}
	
	public boolean checkAutenticazione2(HttpServletRequest req, int livello) {
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
