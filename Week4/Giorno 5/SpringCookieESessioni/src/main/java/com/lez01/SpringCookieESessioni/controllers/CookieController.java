package com.lez01.SpringCookieESessioni.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("cookie")
public class CookieController {
	
	@GetMapping("get")
	public String dammiCookie(HttpServletResponse res) {
		Cookie test = new Cookie("test", "Provacookie");
		Cookie test1 = new Cookie("test1", "Provacookie");
		test.setMaxAge(3600);
		res.addCookie(test);
		res.addCookie(test1);
		return "Prova cookie";
	}
	
	@GetMapping("all")
	public String elencaCookies(HttpServletRequest req) {
		Cookie[] elencoCookie = req.getCookies();
		String s = "Cookies:<br>";
		if (elencoCookie != null)
			for (Cookie c: elencoCookie)
				s += c.getName() + " - " + c.getValue() + "<br>";
		
		return s;
	}
	
}
