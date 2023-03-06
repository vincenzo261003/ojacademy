package com.lez01.recap;

public class Persona {
	
	private String nome = "";
	private String cognome = "";
	
	public Persona() {
		
	}
	
	public Persona(String varNome, String varCognome) {
		setNome(varNome);
		setCognome(varCognome);
	}

	public String getNome() {
		if(!this.nome.isEmpty())
			return nome;
		else
			return "N.D.";
	}

	public void setNome(String nome) {
		if(!nome.isEmpty())
			this.nome = nome;
		else
			this.nome = "N.D.";
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	
	
	
}
