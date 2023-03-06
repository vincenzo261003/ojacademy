package main;

import java.util.Scanner;

public class studenti {

	public static Scanner in = new Scanner(System.in);
	public static boolean disabilitaCiclo1 = false;
	public static String lista = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		do {
			System.out.println("Inserisci cognome oppure QUIT per uscire");
			String cognome = in.nextLine().trim();
			if (!cognome.equals("QUIT")) {
				System.out.println("Inserisci nome");
				String nome = in.nextLine().trim();
				System.out.println("Inserisci matricola");
				String matricola = in.nextLine().trim();
				lista += nome + ", " + cognome + ", " + matricola + "\n";
			}else
				disabilitaCiclo1 = true;
			
		}while(!disabilitaCiclo1);
		
		
		System.out.println("Inserisci il cognome di uno studente e scopri se si trova nella lista");
		String cognome = in.nextLine().trim();
		System.out.println("Cognome trovato " + controlloCognome(cognome) + " volte");
		
		System.out.println("Elenco studenti:");
		System.out.println(lista);
	}

	private static int controlloCognome(String cognome) {
		// TODO Auto-generated method stub
		int c = 0;
		String lista2 = lista;
		while (lista2.indexOf(cognome) >= 0) {
			c++;
			lista2 = lista2.substring(cognome.length() + lista2.indexOf(cognome));
		}
		return c;
	}

}
