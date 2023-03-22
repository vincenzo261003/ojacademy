package com.ospedale.Task03.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ospedale.Task03.dto.PersonaDto;
import com.ospedale.Task03.dto.VisitaDto;
import com.ospedale.Task03.models.Persona;
import com.ospedale.Task03.repositories.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PersonaDto inserisciPersona(PersonaDto stu) {
		Persona p = modelMapper.map(stu, Persona.class);
		Persona x = repository.save(p); //TODO: Gestire i throws e i tipi di response
		return modelMapper.map(x, PersonaDto.class);
	}
	
	public Persona trovaPersona(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<PersonaDto> listaPersone() {
		
		List<Persona> x = repository.findAll();
		
		List<PersonaDto> elenco = new ArrayList<>();
		
		for (Persona temp: x)
			elenco.add(modelMapper.map(temp, PersonaDto.class));
		
		return elenco;
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
