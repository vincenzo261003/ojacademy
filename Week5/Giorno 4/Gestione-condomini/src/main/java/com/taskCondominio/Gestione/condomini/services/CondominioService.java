package com.taskCondominio.Gestione.condomini.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskCondominio.Gestione.condomini.dto.CondominioDto;
import com.taskCondominio.Gestione.condomini.models.Condominio;
import com.taskCondominio.Gestione.condomini.repositories.CondominioRepository;

@Service
public class CondominioService {

	@Autowired
	CondominioRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CondominioDto inserisciCondominio(CondominioDto c) {
		Condominio p = modelMapper.map(c, Condominio.class);
		return modelMapper.map(repository.save(p), CondominioDto.class);
	}
	
	public CondominioDto cercaCondominioId(Integer id) {
		Condominio temp = repository.findById(id).orElse(null);
		if (temp == null)
			return null;
		return modelMapper.map(temp, CondominioDto.class);
	}
	
	public List<CondominioDto> ottieniCondomini(){
		List<Condominio> x = repository.findAll();
		List<CondominioDto> elenco = new ArrayList<>();
		for (Condominio temp: x)
			elenco.add(modelMapper.map(temp, CondominioDto.class));
		return elenco;
	}
	
	public boolean eliminaCondominioId(Integer id) {
		if (id == null || id < 0)
			return false;
		if (this.cercaCondominioId(id) == null)
			return false;
		repository.deleteById(id);
		return true;
	}
	
	public CondominioDto aggiornaCondominio(Integer id, CondominioDto c) {
		Condominio temp = repository.findById(id).orElse(null);
		if (temp == null)
			return null;		
		Condominio p = modelMapper.map(c, Condominio.class);
		p.setIdcondominio(temp.getIdcondominio());
		return modelMapper.map(repository.save(p), CondominioDto.class);
	}

	public CondominioDto cercaCondominioCodice(String varCodice) {
		Condominio temp = repository.findByCodice(varCodice).orElse(null);
		if (temp == null)
			return null;
		return modelMapper.map(temp, CondominioDto.class);
	}
	
	public Condominio cercaCondominioCodice2(String varCondominio) {
		return repository.findByCodice(varCondominio).orElse(null);
	}

	public boolean eliminaCondominioCodice(String varCodice) {
		Condominio temp = repository.findByCodice(varCodice).orElse(null);
		
		if (temp == null)
			return false;
		
		repository.deleteById(temp.getIdcondominio());
		return true;
	}

	public void aggiornaCondominio(CondominioDto u) {
		Condominio temp = repository.findByCodice(u.getCodice()).orElse(null);
		if (temp != null) {	
			Condominio p = modelMapper.map(u, Condominio.class);
			p.setIdcondominio(temp.getIdcondominio());
			repository.save(p);
		}
	}
	
}
