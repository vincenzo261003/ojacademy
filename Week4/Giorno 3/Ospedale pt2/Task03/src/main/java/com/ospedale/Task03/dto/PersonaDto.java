package com.ospedale.Task03.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


public class PersonaDto {
	
	private String nome;
	private String cognome;
	private String codicefiscale;
	
	@JsonManagedReference
	private List<VisitaDto> elencoVisite = new ArrayList<VisitaDto>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodicefiscale() {
		return codicefiscale;
	}
	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}
	public List<VisitaDto> getElencoVisite() {
		return elencoVisite;
	}
	public void setElencoVisite(List<VisitaDto> elencoVisite) {
		this.elencoVisite = elencoVisite;
	}

}
