package com.lez05.polimorfismo;

public class Giocattolo extends Articolo {

	private String nome;

	public Giocattolo() {
		
	}
	public Giocattolo(String nome, String codice, Float prezzo) {
		super();
		this.nome = nome;
		super.codice = codice;
		super.prezzo = prezzo;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Giocattolo [nome=" + nome + ", prezzo=" + prezzo + ", codice=" + codice + "]";
	}
	
	public void stampa() {
		System.out.println("Giocattolo [nome=" + nome + ", prezzo=" + prezzo + ", codice=" + codice + "]");

	}
	
	
}
