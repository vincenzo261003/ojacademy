package com.studente.SpringStudenteRefactor.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studente.SpringStudenteRefactor.models.Studente;
import com.studente.SpringStudenteRefactor.repositories.StudenteRepository;

import dto.StudenteDto;

@Service
public class StudenteService {

	@Autowired
	private StudenteRepository repo;
	
	public StudenteDto cercaStudPerId(Integer varId) {
		Studente temp = repo.findById(varId).orElse(null);
		
		if (temp != null) {
			StudenteDto dto = new StudenteDto();
			dto.setMatricola(temp.getMatricola());
			dto.setNominativo(temp.getNominativo());
			
			return dto;
		}
		
		return null;
	}
	
	public StudenteDto cercaStudPerMatr(String varMatr) {
		Studente temp = repo.findByMatricola(varMatr).orElse(null);
		
		if (temp != null) {
			StudenteDto dto = new StudenteDto();
			dto.setMatricola(temp.getMatricola());
			dto.setNominativo(temp.getNominativo());
			
			return dto;
		}
		
		return null;
		
	}
	
	public List<StudenteDto> cercaPerNominativo(String varNomi) {
		List<Studente> elenco = repo.findByNominativo(varNomi).orElse(null);
		List<StudenteDto> elencoDto = new ArrayList<>();
		
		for (Studente temp: elenco) {
			StudenteDto dto = new StudenteDto();
			dto.setMatricola(temp.getMatricola());
			dto.setNominativo(temp.getNominativo());
			elencoDto.add(dto);
		}
		
		return elencoDto;
	}
	
}
