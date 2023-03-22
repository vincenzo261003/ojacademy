package com.ospedale.Task03.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ospedale.Task03.models.Persona;
import com.ospedale.Task03.repositories.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository repository;
	
	public Persona inserisciPersona(Persona stu) {
		return repository.save(stu);
	}
	
	public Persona trovaPersona(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Persona> listaPersone() {
		return repository.findAll();
	}
	
	public boolean eliminaPersona(Integer id) {
		if (id == null || id < 0)
			return false;
		
		if (this.trovaPersona(id) == null)
			return false;
		
		repository.deleteById(id);
		return true;
	}
	
	public Persona aggiornaPersona(Integer varID, Persona stu) {
		if (this.trovaPersona(varID) == null)
			return null;
		return repository.save(stu);
	}
	
}
