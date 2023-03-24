package com.lez01.SpringCookieESessioni.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("sessione-acl")
public class LoginSessioneController {
	
	@GetMapping("login")
	public String effettuaLogin(@RequestParam String user, @RequestParam String psw, HttpServletRequest req) {
		HttpSession sessione = req.getSession();
		
		if (user.equals("user") && psw.equals("password")) {
			sessione.setAttribute("role", "user");
			return "Login come utente";
		}
		
		if (user.equals("admin") && psw.equals("12345")) {
			sessione.setAttribute("role", "admin");
			return "Login come admin";
		}
		
		return "Errore autenticazione";
	}
	
	
	@GetMapping("profilo")
	public String paginaProfilo(HttpServletRequest req) {
		
		HttpSession sessione = req.getSession();
		try {
			switch ((String)sessione.getAttribute("role")) {
				case "user":
					return "Profilo utente";
				case "admin":
					return "Profilo amdin";
			}
		} catch (Exception e) {
			return "Errore di casting: " + e.getMessage();
		}
		return "Errore";
	}
	
	
}
