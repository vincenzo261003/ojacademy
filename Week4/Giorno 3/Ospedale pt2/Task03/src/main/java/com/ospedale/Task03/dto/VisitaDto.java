package com.ospedale.Task03.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;


public class VisitaDto {

private String codice;
	
	private String secret;
	private String esito;
	private Date datavisita;
	
	@JsonBackReference
	private PersonaDto paziente;

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public Date getDatavisita() {
		return datavisita;
	}

	public void setDatavisita(Date datavisita) {
		this.datavisita = datavisita;
	}

	public PersonaDto getPaziente() {
		return paziente;
	}

	public void setPaziente(PersonaDto paziente) {
		this.paziente = paziente;
	}
	
	public void genCodice() {
		this.codice = java.util.UUID.randomUUID().toString();
	}

	public void genSecret() {
		this.secret = java.util.UUID.randomUUID().toString();
	}
	
}
