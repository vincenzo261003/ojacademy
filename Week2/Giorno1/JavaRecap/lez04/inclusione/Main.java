package com.lez04.inclusione;

public class Main {

	public static void main(String[] args) {

		Indirizzo spe = new Indirizzo("VIa le mani dal naso", "Roma", "RM", "00123");
		Indirizzo fat = new Indirizzo("Piazza la bomba e scappa", "Roma", "RM", "00123");
		
		Persona per = new Persona("Giovanni Pace", spe, fat);
		
	}

}
