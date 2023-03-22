package com.ospedale.Task03.models;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Visite")
public class Visita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idvisita;
	
	@Column
	private String nominativo;

	@Column
	private String codicefiscale;
	
	@Column
	private String codice;
	
	@Column
	private String secret;
	
	@Column
	private String esito;
	
	@Column
	private Date datavisita;
	
	public Visita() {}

	public Integer getIdvisita() {
		return idvisita;
	}

	public void setIdvisita(Integer idvisita) {
		this.idvisita = idvisita;
	}

	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public String getCodicefiscale() {
		return codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
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
	
}
