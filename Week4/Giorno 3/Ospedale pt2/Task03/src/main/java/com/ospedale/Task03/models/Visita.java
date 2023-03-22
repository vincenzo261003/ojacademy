package com.ospedale.Task03.models;

import java.sql.Date;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "Visite")
public class Visita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idvisita;
	
	@Column
	private String codice;
	
	@Column
	private String secret;
	
	@Column
	private String esito;
	
	@Column
	private Date datavisita;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "personaRIF")
	@JsonManagedReference
	private Persona paziente;
	
	public Visita() {}

	public Integer getIdvisita() {
		return idvisita;
	}

	public void setIdvisita(Integer idvisita) {
		this.idvisita = idvisita;
	}

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

	public void genCodice() {
		this.codice = java.util.UUID.randomUUID().toString();
	}

	public void genSecret() {
		this.secret = java.util.UUID.randomUUID().toString();
	}

	public Persona getPaziente() {
		return paziente;
	}

	public void setPaziente(Persona paziente) {
		this.paziente = paziente;
	}
	
}
