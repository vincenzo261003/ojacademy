package com.coffee.ListaCaffe.dto;

public class StudenteDto {
	
	String codice;
	String nome;
	String cognome;
	Integer caffe;
	Integer moltiplicatori;
	
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
