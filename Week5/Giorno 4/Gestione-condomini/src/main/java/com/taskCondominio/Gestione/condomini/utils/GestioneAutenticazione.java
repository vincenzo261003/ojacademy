package com.taskCondominio.Gestione.condomini.utils;

import org.springframework.stereotype.Component;

import com.taskCondominio.Gestione.condomini.dto.UtenteDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Component
public class GestioneAutenticazione {

	public boolean checkAutenticazione(HttpServletRequest req, int livello) {
		HttpSession sessione = req.getSession();
		
		//Get utente check sessione
		UtenteDto user = null;
		try {
			user = (UtenteDto)sessione.getAttribute("user");
		} catch (Exception e) {
			return false;
		}
		
		//Return in base al livello richiesto
		switch (livello) {
			case 0:
				return true;
			case 1: 
				if (user != null && user.isIsadmin())
					return true;
				else 
					return false;
		}
		
		//Errore?
		return false;
	}
	
	public boolean checkAutenticazione2(HttpServletRequest req, String codice) {
		HttpSession sessione = req.getSession();
		
		//Get utente check sessione
		UtenteDto user = null;
		try {
			user = (UtenteDto)sessione.getAttribute("user");
		} catch (Exception e) {
			return false;
		}
		
		if(user != null && (user.getCondominio().getCodice().equals(codice) || user.isIsadmin()))
			return true;
		
		//Errore?
		return false;
	}
	
}
