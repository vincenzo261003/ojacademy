package com.lez05.polimorfismo;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Giocattolo gioUno = new Giocattolo("Macchinina", "MAC1234", 78.5f);
		Giocattolo gioDue = new Giocattolo("Aeroplanino", "AER1234", 145.5f);
		Rivista rivUno = new Rivista("Ciao", "CIA12345", 0.5f);
		Rivista rivDue = new Rivista("ioProgrammo", "PROF1234", 3.5f);
		
//		ArrayList<Giocattolo> elencoGiochi = new ArrayList<Giocattolo>();
//		elencoGiochi.add(gioUno);
//		elencoGiochi.add(gioDue);
//		
//		ArrayList<Rivista> elencoRiviste = new ArrayList<Rivista>();
//		elencoRiviste.add(rivUno);
//		elencoRiviste.add(rivDue);
		
		ArrayList<Articolo> elenco = new ArrayList<>();
		elenco.add(gioUno);
		elenco.add(gioDue);
		elenco.add(rivUno);
		elenco.add(rivDue);
		
		for(int i=0; i<elenco.size(); i++) {
			Articolo temp = elenco.get(i);
			
//			System.out.println(temp.toString());
			temp.stampa();
		}
		
	}

}
