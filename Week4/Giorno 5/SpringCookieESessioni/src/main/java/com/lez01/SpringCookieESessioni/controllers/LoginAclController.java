package com.lez01.SpringCookieESessioni.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("cookie-acl")
public class LoginAclController {
	
	@GetMapping("login")
	public String effettuaLogin(@RequestParam String user, @RequestParam String psw, HttpServletResponse res) {
		if (user.equals("user") && psw.equals("password")) {
			Cookie c = new Cookie("role", "user");
			res.addCookie(c);
			c.setMaxAge(3600);
			return "Login come utente";
		}
		
		if (user.equals("admin") && psw.equals("password")) {
			Cookie c = new Cookie("role", "admin");
			res.addCookie(c);
			c.setMaxAge(3600);
			return "Login come admin";
		}
		
		return "Errore di autenticazione";
	}
	
	@GetMapping("profilo")
	public String paginaProfilo(HttpServletRequest req) {
		Cookie[] elenco = req.getCookies();
		
		if (elenco != null)
			for (Cookie c: elenco)
				if (c.getName().equals("role") && c.getValue().equals("user"))
					return "Sono la pagina profilo utente";
				else if (c.getName().equals("role") && c.getValue().equals("admin"))
					return "Sono la pagina profilo admin";
		return "Errore";
	}
	
}
