package com.coffee.ListaCaffe.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Caffe")
public class Studente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	Integer id;
	
	@Column
	String codice;
	
	@Column
	String nome;
	
	@Column
	String cognome;
	
	@Column
	Integer caffe;
	
	@Column
	Integer moltiplicatori;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
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

	public Integer getCaffe() {
		return caffe;
	}

	public void setCaffe(Integer caffe) {
		this.caffe = caffe;
	}

	public Integer getMoltiplicatori() {
		return moltiplicatori;
	}

	public void setMoltiplicatori(Integer moltiplicatori) {
		this.moltiplicatori = moltiplicatori;
	}
	
}
