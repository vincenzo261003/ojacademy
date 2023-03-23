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
	
	public PersonaDto trovaPersona(Integer id) {
		
		Persona temp = repository.findById(id).orElse(null);
		
		if (temp == null)
			return null;
		
		return modelMapper.map(temp, PersonaDto.class);
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
	
	public PersonaDto aggiornaPersona(Integer varID, PersonaDto stu) {
		Persona temp = repository.findById(varID).orElse(null);
		if (temp == null)
			return null;		
		Persona p = modelMapper.map(stu, Persona.class);
		p.setCodicefiscale(temp.getCodicefiscale());
		p.setIdpersona(temp.getIdpersona());
		return modelMapper.map(repository.save(p), PersonaDto.class);
	}
	
}
