package com.lezValentini.EsRestAPI.repositories;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.lezValentini.EsRestAPI.models.Utente;

@Repository
public class UtenteRepository {

	HashMap<String, Utente> storage = new HashMap<>();
	
	public String insert(Utente u) {
		String s = UUID.randomUUID().toString();
		storage.put(s, u);
		return s;
	}

	public Utente findById(String varID) {
		return storage.get(varID);
	}
	
}
