package com.gestioneannunci.Gestione.annunci.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestioneannunci.Gestione.annunci.dto.UtenteDto;
import com.gestioneannunci.Gestione.annunci.models.Utente;
import com.gestioneannunci.Gestione.annunci.repositories.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	UtenteRepository repository;
	
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
	
	public UtenteDto cercaUtenteUsername(String username) {
		Utente temp = repository.findByUsername(username).orElse(null);
		if (temp == null)
			return null;
		return modelMapper.map(temp, UtenteDto.class);
	}
	
	public UtenteDto cercaUtenteUserPass(UtenteDto user) {
		Utente temp = repository.findByUsername(user.getUsername()).orElse(null);
		if (temp == null)
			return null;
		if (!temp.getPass().equals(user.getPass()))
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
	
	public UtenteDto aggiornaUtente(Integer id, UtenteDto c) {
		Utente temp = repository.findById(id).orElse(null);
		if (temp == null)
			return null;		
		Utente p = modelMapper.map(c, Utente.class);
		p.setIdutente(temp.getIdutente());
		return modelMapper.map(repository.save(p), UtenteDto.class);
	}
	
}
