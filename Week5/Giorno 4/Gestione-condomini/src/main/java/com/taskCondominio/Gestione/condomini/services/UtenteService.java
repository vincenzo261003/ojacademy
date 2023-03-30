package com.taskCondominio.Gestione.condomini.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskCondominio.Gestione.condomini.dto.UtenteDto;
import com.taskCondominio.Gestione.condomini.models.Condominio;
import com.taskCondominio.Gestione.condomini.models.Utente;
import com.taskCondominio.Gestione.condomini.repositories.UtenteRepository;

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
	
	public UtenteDto inserisciUtente2(UtenteDto c, Condominio con) {
		Utente p = modelMapper.map(c, Utente.class);
		p.setCondominio(con);
		return modelMapper.map(repository.save(p), UtenteDto.class);
	}
	
	public UtenteDto cercaUtenteId(Integer id) {
		Utente temp = repository.findById(id).orElse(null);
		if (temp == null)
			return null;
		return modelMapper.map(temp, UtenteDto.class);
	}
	
	public UtenteDto cercaUtenteUsername(String username) {
		Utente temp = repository.findByCodiceappartamento(username).orElse(null);
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
	
	public UtenteDto aggiornaUtente(Integer id, UtenteDto c) {
		Utente temp = repository.findById(id).orElse(null);
		if (temp == null)
			return null;		
		Utente p = modelMapper.map(c, Utente.class);
		p.setIdutente(temp.getIdutente());
		return modelMapper.map(repository.save(p), UtenteDto.class);
	}

	public boolean eliminaUtenteCodice(String varAppartamento) {
		Utente temp = repository.findByCodiceappartamento(varAppartamento).orElse(null);
		
		if (temp == null)
			return false;
		
		repository.deleteById(temp.getIdutente());
		return true;
	}

	public void aggiornaUtente(UtenteDto u) {
		Utente temp = repository.findByCodiceappartamento(u.getCodiceappartamento()).orElse(null);
		
		if (temp != null) {
			Utente p = modelMapper.map(u, Utente.class);
			p.setCondominio(temp.getCondominio());
			p.setIdutente(temp.getIdutente());
			repository.save(p);
		}
	}
	
}
