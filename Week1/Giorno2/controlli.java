package main;

import java.util.ArrayList;
import java.util.Scanner;

public class controlli {

	public static Scanner in = new Scanner(System.in);
    public static boolean disabilitaCiclo0 = false;
    public static boolean disabilitaCiclo1 = false;
	public static boolean disabilitaCiclo2 = false;
	
	public static ArrayList<String> lista = new ArrayList<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Avvio();
	}

	private static void Avvio() {
		// TODO Auto-generated method stub
		int s1 = 0;
		
		while((s1 != 3) && !disabilitaCiclo0){
			System.out.println("");
			System.out.println("Elenco opzioni");
			System.out.println("1) Aggiungi elemento");
			System.out.println("2) Stampa lista");
			System.out.println("3) Quit");
			System.out.println("Inserisci il numero corrispondente alla tua scelta");
			s1 = Integer.valueOf(in.nextLine());
			
			switch(s1) {
				case 1:
					AggiungiElemento();
					break;
				case 2:
					System.out.println("\nLista prodotti: " + lista);
					break;
				case 3:
					System.out.println("\nChiusura programma");
					break;
				default:
					System.out.println("\nInserisci una delle opzioni nel menù");
					break;
			}
		}
	}

	private static void AggiungiElemento() {
		// TODO Auto-generated method stub
		System.out.println("Scrivi il prodotto da aggiungere alla lista");
		String p = in.nextLine().trim().toUpperCase();
		
		if (!lista.contains(p))
			lista.add(p);
		else
			System.out.println("Prodotto già presente");
		
		lista.sort(null);
	}

}
