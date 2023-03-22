package com.ospedale.Task03.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ospedale.Task03.dto.VisitaDto;
import com.ospedale.Task03.models.Visita;
import com.ospedale.Task03.repositories.VisitaRepository;

@Service
public class VisitaService {
	
	@Autowired
	private VisitaRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public VisitaDto inserisciVisita(VisitaDto stu) {
		
		Visita p = modelMapper.map(stu, Visita.class);
		
		Visita x = repository.save(p);
		
		return modelMapper.map(x, VisitaDto.class);
	}
	
	public Visita trovaVisita(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
//	public Visita trovaVisitaSecret(String cod, String sec) {
//		return repository.findBySecretCode(cod, sec);
//	}
//	
//	public List<Visita> trovaVisitaCF(String cf) {
//		return repository.findByCF(cf);
//	}
//	
//	public List<Visita> trovaVisiteData(Date data) {
//		return repository.findByDate(data);
//	}
//	
//	public List<Visita> trovaVisiteDate(Date dateStart, Date dateEnd) {
//		return repository.findByDates(dateStart, dateEnd);
//	}
	
	public List<VisitaDto> listaVisite() {
		List<Visita> x = repository.findAll();
		
		List<VisitaDto> elenco = new ArrayList<>();
		
		for (Visita temp: x)
			elenco.add(modelMapper.map(temp, VisitaDto.class));
		
		return elenco;
	}
	
	public boolean eliminaVisita(Integer id) {
		if (id == null || id < 0)
			return false;
		
		if (this.trovaVisita(id) == null)
			return false;
		
		repository.deleteById(id);
		return true;
	}
	
	public Visita aggiornaVisita(Integer varID, Visita stu) {
		if (this.trovaVisita(varID) == null)
			return null;
		return repository.save(stu);
	}
	
}
