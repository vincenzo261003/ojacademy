package com.task00.task00ThymeLeaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping("ping")
@EnableWebMvc
public class HelloController {
	
	@GetMapping
	public String paginaHello() {
		return "paginaProva";
	}	
	
}