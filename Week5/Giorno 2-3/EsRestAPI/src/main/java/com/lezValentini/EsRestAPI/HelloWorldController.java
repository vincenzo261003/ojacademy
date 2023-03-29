package com.lezValentini.EsRestAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lezValentini.EsRestAPI.services.HelloService;

@RestController
@RequestMapping("hello")
public class HelloWorldController {
	
	@Autowired
	HelloService service;
	
	@GetMapping
	public String hello() {
		return "Hello world";
	}
	
	@GetMapping("/persona")
	public String helloPersona(@RequestParam String nome) {
		return "Ciao " + nome + ", ritorna presto";
	}
	
	@GetMapping("/reverse")
	public String helloReverse(@RequestParam String nome) {
		return service.reverse(nome);
	}
	
}
