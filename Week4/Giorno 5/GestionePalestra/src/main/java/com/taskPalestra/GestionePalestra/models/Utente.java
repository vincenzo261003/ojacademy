package com.taskPalestra.GestionePalestra.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "utenti")
//@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idutente;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@Column
	private String email;
	
	@Column
	private String pass;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( name="personacorso", 
		joinColumns = { @JoinColumn(name="idutenterif", referencedColumnName = "idutente") },
		inverseJoinColumns = { @JoinColumn(name="idcorsorif", referencedColumnName = "idcorso") }
	)
	@JsonBackReference
	private List<Corso> elenco_corsi = new ArrayList<Corso>();

	public Utente() {}
	
	public Integer getIdutente() {
		return idutente;
	}

	public void setIdutente(Integer idUtente) {
		this.idutente = idUtente;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<Corso> getElenco_corsi() {
		return elenco_corsi;
	}

	public void setElenco_corsi(List<Corso> elenco_corsi) {
		this.elenco_corsi = elenco_corsi;
	}
	
}
