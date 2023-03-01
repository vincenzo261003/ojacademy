package main;

import java.util.ArrayList;

public class Pietanza {
	
	private String nome;
	private ArrayList<String> ingredienti;
	private float prezzo;
	
	public Pietanza (String n, ArrayList<String> i, float p) {
		this.nome = n;
		this.ingredienti = i;
		this.prezzo = p;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<String> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(ArrayList<String> ingredienti) {
		this.ingredienti = ingredienti;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public String toString() {
		String s = this.nome;
		s += "\n- Ingredienti: " + this.ingredienti;
		s += "\n- Prezzo: " + this.prezzo;
		return s;
	}
	
}
