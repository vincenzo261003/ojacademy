package com.taskPalestra.GestionePalestra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.taskPalestra.GestionePalestra.dto.UtenteDto;
import com.taskPalestra.GestionePalestra.services.UtenteService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("palestra")
@EnableWebMvc
public class LoginSessioneController {

	@Autowired
	private UtenteService service;
	
	@GetMapping("login")
	public String mostraLogin(Model model) {
		UtenteDto u = new UtenteDto();
		model.addAttribute("utente", u);
		return "loginform";
	}
	
	@PostMapping("login")
	public String effettuaLogin(@ModelAttribute("utente") UtenteDto objStud, HttpServletRequest request, Model model) {
		HttpSession sessione = request.getSession();
		
		String psw = objStud.getPass();
		UtenteDto temp = service.cercaUtenteEmail(objStud.getEmail());
		
		if(temp.getPass().equals(psw)) {
			if (temp.isIsadmin())
				sessione.setAttribute("ruolo", "ADMIN");
			else
				sessione.setAttribute("ruolo", "USER");
			sessione.setAttribute("user", temp);
			model.addAttribute("utente", temp);
			model.addAttribute("modifica", true);
			model.addAttribute("admin", sessione.getAttribute("ruolo").equals("ADMIN"));
			return "dettaglioutente";
		}
		return "error";
	}
	
	@GetMapping("profilo")
	public String paginaProfilo(Model model, HttpServletRequest request) {
		
		HttpSession sessione = request.getSession();
		
		try {
			switch((String)sessione.getAttribute("ruolo")) {
				case "USER":
					return "profiloutente";
				case "ADMIN":
					return "redirect:/palestra/utenti/all";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "error";
	}
}

