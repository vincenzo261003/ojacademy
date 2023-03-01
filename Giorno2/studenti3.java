package main;

import java.util.Scanner;

public class studenti3 {
	
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] elenco = {"Marco, Prova, #3424", "Manuel, Prova, #3414", "Prova, Prova, #3424"};
		System.out.println("Inserisci la matricola da cercare");
		String m = in.nextLine().trim();
		cercaMatricola(m, elenco);
		System.out.println("Esecuzione terminata");
	}

	private static void cercaMatricola(String m, String[] elenco) {
		// TODO Auto-generated method stub
		for (int i = 0; i < elenco.length; i++) {
			if (elenco[i].split(", ")[2].equals(m))
				System.out.println(elenco[i]);
		}
	}

}
