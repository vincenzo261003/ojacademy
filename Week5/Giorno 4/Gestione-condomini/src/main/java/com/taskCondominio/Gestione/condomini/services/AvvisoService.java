package com.taskCondominio.Gestione.condomini.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskCondominio.Gestione.condomini.models.Avviso;
import com.taskCondominio.Gestione.condomini.models.Condominio;
import com.taskCondominio.Gestione.condomini.repositories.AvvisoRepository;
import com.taskCondominio.Gestione.condomini.repositories.CondominioRepository;

@Service
public class AvvisoService {

	@Autowired
	AvvisoRepository repository;
	
	@Autowired
	CondominioRepository repository2;
	
	public Avviso inserisciAvviso(Avviso c) {
		return repository.save(c);
	}
	
	public Avviso cercaAvvisoId(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Avviso> ottieniAvvisi(){
		return repository.findAll();
	}
	
	public boolean eliminaAvvisoId(Integer id) {
		if (id == null || id < 0)
			return false;
		if (this.cercaAvvisoId(id) == null)
			return false;
		repository.deleteById(id);
		return true;
	}
	
	public Avviso aggiornaAvviso(Integer id, Avviso c) {
		Avviso temp = repository.findById(id).orElse(null);
		if (temp == null)
			return null;		
		c.setIdavviso(temp.getIdavviso());
		return repository.save(c);
	}

	public void inserisciAvviso(Avviso objAvviso, String varCondominio) {
		Condominio c = repository2.findByCodice(varCondominio).orElse(null);
		objAvviso.setCondominio(c);
		repository.save(objAvviso);
	}

	
}
