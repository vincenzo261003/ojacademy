package com.lez01.SpringCookieESessioni.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("cookiesingolo")
public class LoginSempliceController {
	
	@GetMapping("login")
	public String effettuaLogin(@RequestParam String user, @RequestParam String psw, HttpServletResponse res) {
		if (user.equals("admin") && psw.equals("password")) {
			Cookie c = new Cookie("isLoggato", "true");
			res.addCookie(c);
			c.setMaxAge(3600);
			return "Login success";
		}
		return "Errore di autenticazione";
	}
	
	@GetMapping("profilo")
	public String paginaProfilo(HttpServletRequest req) {
		Cookie[] elenco = req.getCookies();
		
		boolean isLoggato = false;
		
		if (elenco != null)
			for (Cookie c: elenco)
				if (c.getName().equals("isLoggato") && c.getValue().equals("true"))
					isLoggato = true;
		if (isLoggato)
			return "Sono la pagina profilo";
		else
			return "Errore";
	}
	
}
