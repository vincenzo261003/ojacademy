package main;
import java.util.Scanner;

public class main {
	
    public static Scanner in = new Scanner(System.in);
    public static boolean disabilitaCiclo0 = false;
    public static boolean disabilitaCiclo1 = false;
	public static boolean disabilitaCiclo2 = false;
	
	public static int c = 0;
	
	public static String username = null;
	public static String password = null;
	
	public static void main(String[] args) {
		Autenticazione();
		in.close();
	}
	
	private static void Autenticazione() {
		int s1 = 0;
		
		while((s1 != 2) && !disabilitaCiclo0){
			System.out.println("");
			System.out.println("Elenco opzioni");
			System.out.println("1) Login");
			System.out.println("2) Logout");
			System.out.println("3) Registrazione");
			System.out.println("Inserisci il numero corrispondente alla tua scelta");
			s1 = Integer.valueOf(in.nextLine());
			
			switch(s1) {
				case 1:
					if (Login())
						Programma();
					else
						System.out.println("Credenziali errate");
					break;
				case 2:
					System.out.println("\nArresto");
					break;
				case 3:
					if (username == null)
						Register();
					else
						System.out.println("Credenziali già presenti");
					break;
				default:
					System.out.println("\nInserisci una delle opzioni nel menù");
					break;
			}
		}
		
	}

	private static void Register() {
		System.out.println("Inserisci username");
		username = in.nextLine().trim();
		System.out.println("Inserisci password");
		password = in.nextLine().trim();
	}

	private static boolean Login() {
		System.out.println("Inserisci username");
		String user = in.nextLine().trim();
		System.out.println("Inserisci password");
		String pwd = in.nextLine().trim();
		return (user.equals(username) && pwd.equals(password));
	}

	private static void Programma() {
		int s1 = 0; 
		
		while((s1 != 2) && !disabilitaCiclo1){
			System.out.println("");
			System.out.println("Elenco opzioni");
			System.out.println("1) Calcolatrice");
			System.out.println("2) Esci");
			System.out.println("Inserisci la tua scelta");
			s1 = Integer.valueOf(in.nextLine());
			
			switch(s1) {
				case 1:
					Calcolatrice();
					break;
				case 2:
					System.out.println("\nArresto");
					break;
				default:
					System.out.println("\nInserisci una delle opzioni nel menù");
					break;
			}
			
		}
		
	}

	public static void Calcolatrice() {
		int s1 = 0;
		
		while((s1 != 2) && !disabilitaCiclo2){
			System.out.println("");
			System.out.println("Elenco opzioni");
			System.out.println("1) Calcola");
			System.out.println("2) Esci");
			System.out.println("Inserisci la tua scelta");
			s1 = Integer.valueOf(in.nextLine());
			
			switch(s1) {
				case 1:{
					System.out.println("");
					System.out.println("Inserisci il primo valore");
					double n1 = Double.valueOf(in.nextLine());
					System.out.println("Inserisci il secondo valore");
					double n2 = Double.valueOf(in.nextLine());
					System.out.println("Scegli il tipo di operazione:");
					System.out.println("1) Addizione");
					System.out.println("2) Sottrazione");
					System.out.println("3) Moltiplicazione");
					System.out.println("4) Divisione");
					int s2 = Integer.valueOf(in.nextLine());
					
					switch (s2) {
						case 1:
							Addizione(n1, n2);
							break;
						case 2:
							Sottrazione(n1, n2);
							break;
						case 3:
							Moltiplicazione(n1, n2);
							break;
						case 4:
							Divisione(n1, n2);
							break;
						default:
							System.out.println("\nInserisci un'operazione valida");
							break;
					}
					
					c++; 
				}break;
				case 2:
					System.out.println("\nChiusura calcolatrice, hai eseguito " + c + " calcoli");
					break;
				default:
					System.out.println("\nInserisci una delle opzioni nel menù");
					break;
			}
			
		}
		
	}

	private static void Sottrazione(double n1, double n2) {
		double res = n1 - n2;
		System.out.println("Risultato sottrazione: " + res);
		calcoloSbagliato(res);
	}

	private static void calcoloSbagliato(double res) {
		int randomNum = (int)(Math.random() * 101);
		while (randomNum == res) {
			randomNum = (int)(Math.random() * 101);
		}
		
		System.out.println("Risultato sbagliato: " + randomNum);
	}

	private static void Moltiplicazione(double n1, double n2) {
		double res = n1 * n2;
		System.out.println("Risultato moltiplicazione: " + res);
		calcoloSbagliato(res);
		
	}

	private static void Divisione(double n1, double n2) {
		double res = n1 / n2;
		System.out.println("Risultato divisione: " + res);
		calcoloSbagliato(res);
		
	}

	private static void Addizione(double n1, double n2) {
		double res = n1 + n2;
		System.out.println("Risultato addizione: " + res);
		calcoloSbagliato(res);
		
	}
	
} 
