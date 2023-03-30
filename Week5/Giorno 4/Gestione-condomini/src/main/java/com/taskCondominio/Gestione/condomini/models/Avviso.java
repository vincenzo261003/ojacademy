package com.taskCondominio.Gestione.condomini.models;

import java.sql.Date;

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
@Table(name = "Avvisi")
public class Avviso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idavviso;
	
	@Column
	private Date dataavviso;
	
	@Column
	private String titolo;
	
	@Column
	private String descrizione;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idcondominiorif")
	private Condominio condominio;

	public Integer getIdavviso() {
		return idavviso;
	}

	public void setIdavviso(Integer idavviso) {
		this.idavviso = idavviso;
	}

	public Date getDataavviso() {
		return dataavviso;
	}

	public void setDataavviso(Date dataavviso) {
		this.dataavviso = dataavviso;
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

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

}
