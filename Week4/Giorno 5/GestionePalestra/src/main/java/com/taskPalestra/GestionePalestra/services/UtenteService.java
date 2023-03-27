package com.taskPalestra.GestionePalestra.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskPalestra.GestionePalestra.dto.UtenteDto;
import com.taskPalestra.GestionePalestra.models.Utente;
import com.taskPalestra.GestionePalestra.repositories.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UtenteDto inserisciUtente(UtenteDto c) {
		Utente p = modelMapper.map(c, Utente.class);
		return modelMapper.map(repository.save(p), UtenteDto.class);
	}
	
	public UtenteDto cercaUtenteId(Integer id) {
		Utente temp = repository.findById(id).orElse(null);
		if (temp == null)
			return null;
		return modelMapper.map(temp, UtenteDto.class);
	}
	
	public UtenteDto cercaUtenteEmail(String email) {
		Utente temp = repository.findByEmail(email).orElse(null);
		if (temp == null)
			return null;
		return modelMapper.map(temp, UtenteDto.class);
	}
	
	public List<UtenteDto> ottieniUtenti(){
		List<Utente> x = repository.findAll();
		List<UtenteDto> elenco = new ArrayList<>();
		for (Utente temp: x)
			elenco.add(modelMapper.map(temp, UtenteDto.class));
		return elenco;
	}
	
	public boolean eliminaUtenteId(Integer id) {
		if (id == null || id < 0)
			return false;
		if (this.cercaUtenteId(id) == null)
			return false;
		repository.deleteById(id);
		return true;
	}
	
	public boolean eliminaUtenteEmail(String email) {
		Utente temp = repository.findByEmail(email).orElse(null);
		if (temp == null)
			return false;
		repository.delete(temp);
		return true;
	}
	
	public UtenteDto aggiornaUtente(Integer id, UtenteDto c) {
		Utente temp = repository.findById(id).orElse(null);
		if (temp == null)
			return null;		
		Utente p = modelMapper.map(c, Utente.class);
		p.setIdutente(temp.getIdutente());
		return modelMapper.map(repository.save(p), UtenteDto.class);
	}
	
}
