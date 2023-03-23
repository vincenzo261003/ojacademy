package com.task00.task00ThymeLeaf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task00.task00ThymeLeaf.models.Studente;
import com.task00.task00ThymeLeaf.repositories.StudenteRepository;

@Service
public class StudenteService {
	
	@Autowired
	private StudenteRepository repository;
	
	public Studente inserisciStudente(Studente stu) {
		return repository.save(stu);
	}
	
	public Studente trovaStudente(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Studente> listaStudenti() {
		return repository.findAll();
	}
	
	public boolean eliminaStudente(Integer id) {
		if (id == null || id < 0)
			return false;
		
		if (this.trovaStudente(id) == null)
			return false;
		
		repository.deleteById(id);
		return true;
	}
	
	public Studente aggiornaStudente(Integer varID, Studente stu) {
		Studente temp = repository.findById(varID).orElse(null);
		if (temp == null)
			return null;		
		return repository.save(temp);
	}

	public Studente trovaStudenteMatricola(String matricola) {
		List<Studente> students = repository.findByMatricola(matricola);
		return students.get(0);
	}
	
	
}
