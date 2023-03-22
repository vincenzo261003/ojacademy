package com.studente.SpringStudenteRefactor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studente.SpringStudenteRefactor.services.StudenteService;

import dto.StudenteDto;

@RestController
@RequestMapping("studente")
public class StudenteController {

	@Autowired
	private StudenteService service;
	
	@GetMapping("id/{id}")
	public StudenteDto cercaStudenteId(@PathVariable Integer id) {
		return service.cercaStudPerId(id);
	}
	
	@GetMapping("matr/{matr}")
	public StudenteDto cercaStudenteMatricola(@PathVariable String matr) {
		return service.cercaStudPerMatr(matr);
	}
	
	@GetMapping
	public List<StudenteDto> studList(@RequestParam String nominativo) {
		return service.cercaPerNominativo(nominativo);
	}
}
