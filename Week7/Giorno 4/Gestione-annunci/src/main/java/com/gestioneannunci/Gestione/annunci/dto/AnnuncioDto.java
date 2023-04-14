package com.gestioneannunci.Gestione.annunci.dto;

import java.time.LocalDateTime;

public class AnnuncioDto {

	private String codice;
	private String titolo;
	private String descrizione;
	private LocalDateTime datainserimento;
	private UtenteDto autore;
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public LocalDateTime getDatainserimento() {
		return datainserimento;
	}
	public void setDatainserimento(LocalDateTime datainserimento) {
		this.datainserimento = datainserimento;
	}
	public UtenteDto getAutore() {
		return autore;
	}
	public void setAutore(UtenteDto autore) {
		this.autore = autore;
	}
}
