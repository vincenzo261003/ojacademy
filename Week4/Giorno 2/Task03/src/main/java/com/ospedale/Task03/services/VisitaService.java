package com.ospedale.Task03.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ospedale.Task03.models.Visita;
import com.ospedale.Task03.repositories.VisitaRepository;

@Service
public class VisitaService {
	
	@Autowired
	private VisitaRepository repository;
	
	public boolean inserisciVisita(Visita stu) {
		return repository.insert(stu);
	}
	
	public Visita trovaVisita(Integer id) {
		return repository.findById(id);
	}
	
	public Visita trovaVisitaSecret(String cod, String sec) {
		return repository.findBySecretCode(cod, sec);
	}
	
	public List<Visita> trovaVisitaCF(String cf) {
		return repository.findByCF(cf);
	}
	
	public List<Visita> trovaVisiteData(Date data) {
		return repository.findByDate(data);
	}
	
	public List<Visita> trovaVisiteDate(Date dateStart, Date dateEnd) {
		return repository.findByDates(dateStart, dateEnd);
	}
	
	public List<Visita> listaStudenti() {
		return repository.findAll();
	}
	
	public boolean eliminaVisita(Integer id) {
		if (id == null || id < 0)
			return false;
		
		if (this.trovaVisita(id) == null)
			return false;
		
		return repository.delete(id);
	}
	
	public boolean aggiornaVisita(Integer varID, Visita stu) {
		if (this.trovaVisita(varID) == null)
			return false;
		
		stu.setIdvisita(varID);
		return repository.update(stu);
	}
	
}
