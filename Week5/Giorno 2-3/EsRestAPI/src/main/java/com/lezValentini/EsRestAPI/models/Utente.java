package com.lezValentini.EsRestAPI.models;

import java.util.Date;

public class Utente {

	public String nome;
	public String cognome;
	public Date nascita;
	
	public Utente() {}
	
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
	public Date getNascita() {
		return nascita;
	}
	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}
	
	
	
}
