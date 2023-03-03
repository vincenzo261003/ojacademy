package mattino;
import java.util.ArrayList;
import java.util.Scanner;

public class Esercizio {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//Es1: il metodo somma dichiarato sotto la funzione main e richiamato nell'es2
		//prende in input due parametri di tipo intero (x e y) e ne restituisce la somma,
		//sempre sotto forma di intero
		System.out.println("ESERCIZIO 1 - SOMMA");
		System.out.println("Inserisci il primo valore");
		int v1 = Integer.valueOf(in.nextLine().trim());
		System.out.println("Inserisci il secondo valore");
		int v2 = Integer.valueOf(in.nextLine().trim());
		System.out.println("Es1: " + somma(v1,v2));
		System.out.println("Es2: " + somma(5,7));
		
		//Es2: nel metodo chiamato media prendo in input un array di interi x come parametro
		//dopodiché creo una variabile somma che parte da 0 e tramite un ciclo for prendo
		//tutti i valori di x e li sommo alla variabile iniziale, infine ritorno la media
		//calcolata dividendo la somma per la lunghezza dell'array
		System.out.println("ESERCIZIO 2 - MEDIA");
		String risp = "";
		ArrayList<Integer> t = new ArrayList<Integer>();
		do {
			System.out.println("Scrivi un numero da inserire nell'array oppure q per uscire");
			risp = in.nextLine().trim();
			if (!risp.equalsIgnoreCase("q"))
				t.add(Integer.valueOf(risp));
			
		}while(!risp.equals("q"));
		int[] temp = {2, 4, 6, 8, 10};
		System.out.println("Es2: " + media(t.stream().mapToInt(i -> i).toArray()));
		System.out.println("Es3: " + media(temp));
		
		//Es4: nel metodo inverti prendo in input una stringa x come parametro, creo quindi 
		//una variabile di tipo stringa chiamata s dove andrò a creare la stringa invertita
		//e un array di char y ricavato dalla Stringa tramite la funzione x.toCharArray(), 
		//infine ciclo tramite un for partendo dall'ultimo valore dell'array e arrivando a zero
		//creando man mano la stringa invertita con l'operatore += 
		System.out.println("ESERCIZIO 4 - STRINGA INVERTITA");
		System.out.println("Inserisci la stringa da invertire");
		String inv = in.nextLine().trim();
		System.out.println("Es4: " + inverti(inv));
		System.out.println("Es5: " + inverti("ciao"));
	}
	
	public static int somma(int x, int y) {
		return x+y;
	}
	
	public static double media(int[] x) {
		double sum = 0;
		for (int i = 0; i < x.length; i++)
			sum += x[i];
		return sum/x.length;
	}
	
	public static String inverti(String x) {
		String s = "";
		char[] y = x.toCharArray();
		for (int i = y.length-1; i >= 0; i--)
			s += y[i];
		return s;
	}

}
