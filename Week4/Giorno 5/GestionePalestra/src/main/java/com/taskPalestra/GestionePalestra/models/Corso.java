package com.taskPalestra.GestionePalestra.models;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "corsi")
//@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class Corso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idcorso;
	
	@Column
	private String codice;
	
	@Column
	private String nome;
	
	@Column
	private Integer duratacorso;
	
	@Column
	private LocalDateTime datacorso;

	@Column
	private String livellocorso;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( name="personacorso", 
				joinColumns = { @JoinColumn(name="idcorsorif", referencedColumnName = "idcorso") },
				inverseJoinColumns = { @JoinColumn(name = "idutenterif", referencedColumnName = "idutente")})
	@JsonManagedReference
	private List<Utente> elenco_iscritti = new ArrayList<Utente>();
	
	public Corso () {}

	public Integer getIdcorso() {
		return idcorso;
	}

	public void setIdcorso(Integer idcorso) {
		this.idcorso = idcorso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDuratacorso() {
		return duratacorso;
	}

	public void setDuratacorso(Integer duratacorso) {
		this.duratacorso = duratacorso;
	}

	public LocalDateTime getDatacorso() {
		return datacorso;
	}

	public void setDatacorso(LocalDateTime datacorso) {
		this.datacorso = datacorso;
	}

	public String getLivellocorso() {
		return livellocorso;
	}

	public void setLivellocorso(String livellocorso) {
		this.livellocorso = livellocorso;
	}

	public List<Utente> getElenco_iscritti() {
		return elenco_iscritti;
	}

	public void setElenco_iscritti(List<Utente> elenco_iscritti) {
		this.elenco_iscritti = elenco_iscritti;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	
}
