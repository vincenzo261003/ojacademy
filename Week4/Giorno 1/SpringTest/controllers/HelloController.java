package com.lez00.SpringTest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@GetMapping("/saluta")
	public String saluta() {
		return "Ciao Manuel";
	}
	
	@GetMapping("/numero")
	public float numero() {
		return 1.234f;
	}
	
	@GetMapping("/saluta/persona/{nome}")
	public String salutaPersona(@PathVariable String nome) {
		return "Ciao " + nome;
	}
	
	@GetMapping("/saluta/parametri")
	public String salutaParametri(@RequestParam String nome) {
		return nome;
	}
	
	
}
