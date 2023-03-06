package com.lez05.polimorfismo;

public abstract class Articolo {

	protected Float prezzo;
	protected String codice;
	
	public Articolo() {
		
	}
	public Articolo(Float prezzo, String codice) {
		super();
		this.prezzo = prezzo;
		this.codice = codice;
	}
	
	public Float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	@Override
	public String toString() {
		return "Articolo [prezzo=" + prezzo + ", codice=" + codice + "]";
	}
	
	public abstract void stampa();
	
}
