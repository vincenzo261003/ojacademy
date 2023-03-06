package com.lez02.ereditarieta;

public class Persona {
	
	protected String nome = "";
	protected String cognome = "";
	
	public Persona() {
		
	}
	
	public Persona(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
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
	
	public void stampa() {
		System.out.println(this.nome + " " + this.cognome);
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + "]";
	}
	
	
		
}