package com.lezValentini.EsRestAPI.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lezValentini.EsRestAPI.dto.UtenteDto;
import com.lezValentini.EsRestAPI.models.Utente;
import com.lezValentini.EsRestAPI.repositories.UtenteRepository;

@Service
public class UtenteService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UtenteRepository repository;

	public UtenteDto cercaId(String varID) {
		return mapper.map(repository.findById(varID), UtenteDto.class);
	}

	public String inserisci(UtenteDto u) {
		Utente temp = mapper.map(u, Utente.class);
		return repository.insert(temp);
	}

}
