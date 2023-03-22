package com.ospedale.Task03.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "persone")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idpersona;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@Column
	private String codicefiscale;
	
	@OneToMany(mappedBy = "paziente", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Visita> elencoVisite = new ArrayList<Visita>();
	
	public Persona() {}

	public Integer getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Integer idpersona) {
		this.idpersona = idpersona;
	}

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

	public List<Visita> getElencoVisite() {
		return elencoVisite;
	}

	public void setElencoVisite(List<Visita> elencoVisite) {
		this.elencoVisite = elencoVisite;
	}
	
}
