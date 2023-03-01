package main;

import java.util.ArrayList;
import java.util.Scanner;

public class studenti2 {
	
	public static Scanner in = new Scanner(System.in);
	public static boolean disabilitaCiclo1 = false;
	public static ArrayList<String> persone = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		do {
			System.out.println("Inserisci nome oppure Q per uscire");
			String nome = in.nextLine().trim();
			if (!nome.equals("Q"))
				persone.add(nome);
			else
				disabilitaCiclo1 = true;
		}while(!disabilitaCiclo1);
		persone.sort(null);
		System.out.println("Elenco nomi: " + persone);
	}

}
