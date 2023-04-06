package com.coffee.ListaCaffe.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.ListaCaffe.dto.StudenteDto;
import com.coffee.ListaCaffe.models.Studente;
import com.coffee.ListaCaffe.repositories.StudenteRepository;

@Service
public class StudenteService {

	@Autowired
	StudenteRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public boolean inserisciStudente(StudenteDto c) {
		Studente p = modelMapper.map(c, Studente.class);
		if (repository.save(p) == null)
			return false;
		return true;
	}
	
	public StudenteDto cercaStudenteId(Integer id) {
		Studente temp = repository.findById(id).orElse(null);
		if (temp == null)
			return null;
		return modelMapper.map(temp, StudenteDto.class);
	}
	
	public List<StudenteDto> ottieniStudenti(){
		List<Studente> x = repository.findAll();
		List<StudenteDto> elenco = new ArrayList<>();
		for (Studente temp: x)
			elenco.add(modelMapper.map(temp, StudenteDto.class));
		return elenco;
	}
	
	public boolean eliminaStudenteId(Integer id) {
		if (id == null || id < 0)
			return false;
		if (this.cercaStudenteId(id) == null)
			return false;
		repository.deleteById(id);
		return true;
	}
	
	public StudenteDto aggiornaStudente(Integer id, StudenteDto c) {
		Studente temp = repository.findById(id).orElse(null);
		if (temp == null)
			return null;		
		Studente p = modelMapper.map(c, Studente.class);
		p.setId(temp.getId());
		return modelMapper.map(repository.save(p), StudenteDto.class);
	}
	
	public boolean aggiornaStudenteCodice(String cod, StudenteDto c) {
		Studente temp = repository.findByCodice(cod).orElse(null);
		if (temp == null)
			return false;
		Studente p = modelMapper.map(c, Studente.class);
		p.setId(temp.getId());
		if (repository.save(p) == null)
			return false;
		return true;
	}

	public StudenteDto cercaStudenteCodice(String varCodice) {
		Studente temp = repository.findByCodice(varCodice).orElse(null);
		if (temp == null)
			return null;
		return modelMapper.map(temp, StudenteDto.class);
	}

	public boolean eliminaStudenteCodice(String varCodice) {
		Studente temp = repository.findByCodice(varCodice).orElse(null);
		
		if (temp == null)
			return false;
		
		repository.deleteById(temp.getId());
		return true;
	}

	public void aggiornaStudente(StudenteDto u) {
		Studente temp = repository.findByCodice(u.getCodice()).orElse(null);
		if (temp != null) {	
			Studente p = modelMapper.map(u, Studente.class);
			p.setId(temp.getId());
			repository.save(p);
		}
	}

	public boolean aggiungiCaffe(String varCodice) {
		StudenteDto temp = cercaStudenteCodice(varCodice);
		if (temp == null)
			return false;
		temp.setCaffe(temp.getMoltiplicatori() + temp.getCaffe());
		temp.setMoltiplicatori(0);
		return aggiornaStudenteCodice(varCodice, temp);
	}

	public boolean rimuoviCaffe(String varCodice) {
		StudenteDto temp = cercaStudenteCodice(varCodice);
		if (temp == null)
			return false;
		temp.setCaffe(temp.getCaffe()-1);
		return aggiornaStudenteCodice(varCodice, temp);
	}

	public boolean aggiungiMolt(String varCodice) {
		StudenteDto temp = cercaStudenteCodice(varCodice);
		if (temp == null)
			return false;
		temp.setMoltiplicatori(temp.getMoltiplicatori()+1);
		return aggiornaStudenteCodice(varCodice, temp);
	}

	public boolean rimuoviMolt(String varCodice) {
		StudenteDto temp = cercaStudenteCodice(varCodice);
		if (temp == null)
			return false;
		temp.setMoltiplicatori(temp.getMoltiplicatori()-1);
		return aggiornaStudenteCodice(varCodice, temp);
	}
	
}
