package com.gestioneannunci.Gestione.annunci.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Annunci")
public class Annuncio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idannuncio;
	
	@Column
	private String codice;
	
	@Column
	private String titolo;
	
	@Column
	private String descrizione;
	
	@Column
	private LocalDateTime datainserimento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idutenterif")
	private Utente autore;

	public Integer getIdannuncio() {
		return idannuncio;
	}

	public void setIdannuncio(Integer idannuncio) {
		this.idannuncio = idannuncio;
	}

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

	public Utente getAutore() {
		return autore;
	}

	public void setAutore(Utente autore) {
		this.autore = autore;
	}
	
}
