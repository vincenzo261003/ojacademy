package com.lez03.astrazione;

public class Gatto extends Animale {

	private String colore;
	
	public Gatto() {
		super();
		System.out.println("Sono il costruttore di Gatto");
	}
	
	public Gatto(String colore) {
		super();
		this.colore = colore;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	@Override
	public void versoEmesso() {
		System.out.println("Meow");
	}

}
