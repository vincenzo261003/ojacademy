package com.lez02.ereditarieta;

public class Studente extends Persona{

	private String matricola;
	private String nome;

	public Studente(String matricola) {
		super();
		this.matricola = matricola;
	}
	
	public Studente(String varNome, String varCogn, String varMatr) {
		this.matricola = varMatr;
		this.nome = varNome;
		this.cognome = varCogn;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	@Override
	public void stampa() {
		System.out.println(this.nome + " " + this.cognome + " " + this.matricola);
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	
	
	
}
