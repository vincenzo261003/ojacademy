package com.taskCondominio.Gestione.condomini.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("condomini")
@EnableWebMvc
public class LoginSessioneController {

	@Autowired
	private UtenteService service;
	
	@Autowired
	private CondominioService service2;
	
	@GetMapping("login")
	public String mostraLogin(Model model) {
		UtenteDto u = new UtenteDto();
		model.addAttribute("utente", u);
		return "loginform";
	}
	
	@PostMapping("login")
	public String effettuaLogin(@ModelAttribute("utente") UtenteDto objUser, HttpServletRequest request, Model model) {
		HttpSession sessione = request.getSession();
		
		String psw = objUser.getPass();
		UtenteDto temp = service.cercaUtenteUsername(objUser.getCodiceappartamento());
		
		if(temp != null && temp.getPass().equals(psw)) {
			sessione.setAttribute("user", temp);
			if (temp.isIsadmin())
				return "redirect:/condomini/dashboard";
			else
				return "redirect:/condomini/stabile/" + temp.getCondominio().getCodice();
		}
		return "errorLogin";
	}
	
	@GetMapping("dashboard")
	public String mostraDashboardAdmin(Model model, HttpServletRequest request) {
		if (! checkAutenticazione(request, 1))
			return "errorPermessi";
		
		List<CondominioDto> listaCondomini = service2.ottieniCondomini();
		
		model.addAttribute("listacondomini", listaCondomini);
		return "dashboard";
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

