package com.taskPalestra.GestionePalestra.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskPalestra.GestionePalestra.dto.CorsoDto;
import com.taskPalestra.GestionePalestra.models.Corso;
import com.taskPalestra.GestionePalestra.repositories.CorsoRepository;

@Service
public class CorsoService {

	@Autowired
	private CorsoRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CorsoDto inserisciCorso(CorsoDto c) {
		Corso p = modelMapper.map(c, Corso.class);
		return modelMapper.map(repository.save(p), CorsoDto.class);
	}
	
	public CorsoDto cercaCorsoId(Integer id) {
		Corso temp = repository.findById(id).orElse(null);
		if (temp == null)
			return null;
		return modelMapper.map(temp, CorsoDto.class);
	}
	
	public List<CorsoDto> ottieniCorsi(){
		List<Corso> x = repository.findAll();
		List<CorsoDto> elenco = new ArrayList<>();
		for (Corso temp: x)
			elenco.add(modelMapper.map(temp, CorsoDto.class));
		return elenco;
	}
	
	public boolean eliminaCorsoId(Integer id) {
		if (id == null || id < 0)
			return false;
		if (this.cercaCorsoId(id) == null)
			return false;
		repository.deleteById(id);
		return true;
	}
	
	public CorsoDto aggiornaCorso(Integer id, CorsoDto c) {
		Corso temp = repository.findById(id).orElse(null);
		if (temp == null)
			return null;		
		Corso p = modelMapper.map(c, Corso.class);
		p.setIdcorso(temp.getIdcorso());
		return modelMapper.map(repository.save(p), CorsoDto.class);
	}
	
}
