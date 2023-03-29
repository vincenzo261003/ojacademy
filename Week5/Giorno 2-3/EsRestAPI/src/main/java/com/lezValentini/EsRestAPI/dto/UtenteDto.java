package com.lezValentini.EsRestAPI.dto;

import java.util.Date;

public class UtenteDto {

	public String nome;
	public String cognome;
	public Date nascita;
	
	public UtenteDto() {}
	
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
