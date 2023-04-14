package com.gestioneannunci.Gestione.annunci.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestioneannunci.Gestione.annunci.dto.AnnuncioDto;
import com.gestioneannunci.Gestione.annunci.models.Annuncio;
import com.gestioneannunci.Gestione.annunci.repositories.AnnuncioRepository;

@Service
public class AnnuncioService {

	@Autowired
	AnnuncioRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AnnuncioDto inserisciAnnuncio(AnnuncioDto c) {
		Annuncio p = modelMapper.map(c, Annuncio.class);
		return modelMapper.map(repository.save(p), AnnuncioDto.class);
	}
	
	public AnnuncioDto cercaAnnuncioId(Integer id) {
		Annuncio temp = repository.findById(id).orElse(null);
		if (temp == null)
			return null;
		return modelMapper.map(temp, AnnuncioDto.class);
	}
	
	public List<AnnuncioDto> ottieniAnnunci(){
		List<Annuncio> x = repository.findAll();
		List<AnnuncioDto> elenco = new ArrayList<>();
		for (Annuncio temp: x)
			elenco.add(modelMapper.map(temp, AnnuncioDto.class));
		return elenco;
	}
	
	public boolean eliminaAnnuncioId(Integer id) {
		if (id == null || id < 0)
			return false;
		if (this.cercaAnnuncioId(id) == null)
			return false;
		repository.deleteById(id);
		return true;
	}
	
	public AnnuncioDto aggiornaAnnuncio(String cod, AnnuncioDto c) {
		Annuncio temp = repository.findByCodice(cod).orElse(null);
		if (temp == null)
			return null;		
		Annuncio p = modelMapper.map(c, Annuncio.class);
		p.setIdannuncio(temp.getIdannuncio());
		return modelMapper.map(repository.save(p), AnnuncioDto.class);
	}

	public AnnuncioDto cercaAnnuncioCodice(String varCodice) {
		Annuncio temp = repository.findByCodice(varCodice).orElse(null);
		if (temp == null)
			return null;
		return modelMapper.map(temp, AnnuncioDto.class);
	}

	public boolean eliminaAnnuncioCodice(String varCodice) {
		Annuncio temp = repository.findByCodice(varCodice).orElse(null);
		
		if (temp == null)
			return false;
		
		repository.deleteById(temp.getIdannuncio());
		return true;
	}

	public void aggiornaAnnuncio(AnnuncioDto u) {
		Annuncio temp = repository.findByCodice(u.getCodice()).orElse(null);
		if (temp != null) {	
			Annuncio p = modelMapper.map(u, Annuncio.class);
			p.setIdannuncio(temp.getIdannuncio());
			repository.save(p);
		}
	}
	
}
