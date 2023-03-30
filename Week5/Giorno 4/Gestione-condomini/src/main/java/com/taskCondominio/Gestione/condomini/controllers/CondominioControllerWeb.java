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
import com.taskCondominio.Gestione.condomini.utils.GestioneAutenticazione;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/condomini/stabile")
@EnableWebMvc
public class CondominioControllerWeb {
	
	@Autowired
	private CondominioService service;
	
	@Autowired
	private GestioneAutenticazione g;

	@GetMapping("/{varCondominio}")
	public String modUtente(@PathVariable String varCondominio, Model model, HttpServletRequest request){	
		if(! g.checkAutenticazione2(request, varCondominio))
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
		if(! g.checkAutenticazione(request, 1))
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
		if (! g.checkAutenticazione(request, 1))
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
		if(! g.checkAutenticazione(request, 1))
			return "errorPermessi";
		if (! service.eliminaCondominioCodice(varCodice))
			return "error";
		return "redirect:/condomini/dashboard";
	}
	
}
