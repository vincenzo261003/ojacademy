package com.lez05.statiche;
//POJO
public class Studente {

	private String nominativo;
	private String matricola;
	private static Integer contatore = 0;
	
	public Studente() {
		contatore++;
	}

	public Studente(String nominativo, String matricola) {
		super();
		this.nominativo = nominativo;
		this.matricola = matricola;
		contatore++;
	}

	public static Integer getContatore() {
		return contatore;
	}
	
	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	@Override
	public String toString() {
		return "Studente [nominativo=" + nominativo + ", matricola=" + matricola + "]";
	}
	
}
