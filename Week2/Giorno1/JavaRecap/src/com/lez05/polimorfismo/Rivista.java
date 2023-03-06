package com.lez05.polimorfismo;

public class Rivista extends Articolo{

	private String titolo;

	public Rivista() {
		
	}
	public Rivista(String titolo, String codice, Float prezzo) {
		super();
		this.titolo = titolo;
		super.codice = codice;
		super.prezzo = prezzo;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	@Override
	public String toString() {
		return "Rivista [titolo=" + titolo + ", prezzo=" + prezzo + ", codice=" + codice + "]";
	}
	
	public void stampa() {
		System.out.println("Rivista [titolo=" + titolo + ", prezzo=" + prezzo + ", codice=" + codice + "]"); 
	}
}
