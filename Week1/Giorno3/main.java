package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
	
	public static Scanner in = new Scanner(System.in);
	public static ArrayList<Utente> utenti = new ArrayList<Utente>();
	public static ArrayList<Pietanza> piatti = new ArrayList<Pietanza>();
	public static ArrayList<Pietanza> piattiOrdinati = new ArrayList<Pietanza>();
	
	public static int nAdmin = 1;
	public static int id = 1;
	public static int loggedID;
	
	public static boolean disabilitaCicloAuth = false;
	public static boolean disabilitaCicloProgramma = false;
	public static boolean disabilitaCicloOrdinazione = false;
	public static boolean disabilitaCicloAmministrazione = false;

	public static void main(String[] args) {
		// Metodi creati per avere dei dati iniziali
		aggiungiPiatti(); 
		aggiungiUtenti();
		
		
		Autenticazione();
		in.close();
		
	}
	
	private static void aggiungiUtenti() {
		utenti.add(new Utente("admin", "password", id, true));
		id++;
		utenti.add(new Utente("test", "test", id));
		id++;
	}

	private static void Autenticazione() {
		int s1 = 0;
		
		while((s1 != 2) && !disabilitaCicloAuth){
			System.out.println("");
			System.out.println("Elenco opzioni");
			System.out.println("1) Login");
			System.out.println("2) Arresto");
			System.out.println("3) Registrazione");
			System.out.println("4) Amministrazione");
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
					Register();
					break;
				case 4:
					if (LoginAdmin())
						GestioneAdmin();
					else
						System.out.println("Credenziali errate");
					break;
				default:
					System.out.println("\nInserisci una delle opzioni nel menù");
					break;
			}
		}
		
	}
	
	private static void GestioneAdmin() {
		int s1 = 0; 
		
		while((s1 != 5) && !disabilitaCicloAmministrazione){
			System.out.println("");
			System.out.println("Elenco opzioni");
			System.out.println("1) Visualizza lista piatti");
			System.out.println("2) Aggiungi piatto");
			System.out.println("3) Crea admin");
			System.out.println("4) Elimina piatto");
			System.out.println("5) Esci");
			System.out.println("Inserisci la tua scelta");
			s1 = Integer.valueOf(in.nextLine());
			
			switch(s1) {
				case 1:
					VisualizzaListaPiatti(piatti);
					break;
				case 2:
					AggiungiPiatto();
					break;
				case 3:
					CreaAdmin(); 
					break;
				case 4:
					EliminazionePiatto();
					break;
				case 5:
					System.out.println("\nChiusura");
					break;
				default:
					System.out.println("\nInserisci una delle opzioni nel menù");
					break;
			}
			
		}
	}

	private static void EliminazionePiatto() {
		for (int i = 0; i < piatti.size(); i++)
			System.out.println((i+1) + ") " + piatti.get(i).getNome());
		System.out.println("Inserisci il numero del piatto da rimuovere");
		int r = Integer.valueOf(in.nextLine());
		piatti.remove(r-1);
		System.out.println("Piatto rimosso correttamente");
	}

	private static void CreaAdmin() {
		System.out.println("Inserisci username");
		String username = in.nextLine().trim();
		System.out.println("Inserisci password");
		String password = in.nextLine().trim();
		if (!checkUser(username) && nAdmin < 2){
			utenti.add(new Utente(username, password, id, true));
			id++;
			nAdmin++;
			System.out.println("Utente admin creato correttamente");
		}else
			System.out.println("Username già presente nel sistema o massimo admin raggiunto");
		
	}

	private static void AggiungiPiatto() {
		System.out.println("Inserisci il nome del piatto da aggiungere");
		String np = in.nextLine().trim();
		int i = 0;
		boolean trovato = false;
		while (i < piatti.size() && !trovato) {
			if (piatti.get(i).getNome().equalsIgnoreCase(np))
				trovato = true;
			i++;
		}
		if (trovato)
			System.out.println("Piatto già presente nella lista");
		else {
			System.out.println("Inserisci il prezzo");
			float prezzo = Float.valueOf(in.nextLine().trim());
			ArrayList<String> ingredienti = creaListaIngredienti();
			piatti.add(new Pietanza(np, ingredienti, prezzo));
		}
		
	}

	private static ArrayList<String> creaListaIngredienti() {
		boolean disabilitaCicloIngredienti = false;
		ArrayList<String> ingredienti = new ArrayList<String>();
		do {
			System.out.println("Inserisci ingrediente oppure QUIT per uscire");
			String ing = in.nextLine().trim();
			if (!ing.equals("QUIT"))
				ingredienti.add(ing);
			else
				disabilitaCicloIngredienti = true;
			
		}while(!disabilitaCicloIngredienti);
		return ingredienti;
	}

	private static void Programma() {
		int s1 = 0;
		System.out.println("Benvenuto, il tuo saldo ammonta a " + utenti.get(loggedID).getSoldi());
		
		while((s1 != 2) && !disabilitaCicloProgramma){
			System.out.println("");
			System.out.println("Elenco opzioni");
			System.out.println("1) Ordina");
			System.out.println("2) Esci");
			System.out.println("Inserisci la tua scelta");
			s1 = Integer.valueOf(in.nextLine());
			
			switch(s1) {
				case 1:
					Ordina();
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

	private static void Ordina() {
		// TODO Auto-generated method stub
		int s1 = 0; 
		
		while((s1 != 4) && !disabilitaCicloOrdinazione){
			System.out.println("");
			System.out.println("Elenco opzioni");
			System.out.println("1) Ordina piatto");
			System.out.println("2) Visualizza lista piatti");
			System.out.println("3) Calcola conto");
			System.out.println("4) Esci e paga");
			System.out.println("Inserisci la tua scelta");
			s1 = Integer.valueOf(in.nextLine());
			
			switch(s1) {
				case 1:
					OrdinaPiatto();
					break;
				case 2:
					VisualizzaListaPiatti(piatti);
					break;
				case 3:
					calcolaConto(piattiOrdinati);
					break;
				case 4:
					pagamento(piattiOrdinati);
					break;
				default:
					System.out.println("\nInserisci una delle opzioni nel menù");
					break;
			}
			
		}
		
		piattiOrdinati.clear();
	}

	private static void pagamento(ArrayList<Pietanza> p) {
		float wallet = utenti.get(loggedID).getSoldi() - calcolaConto(p);
		utenti.get(loggedID).setSoldi(wallet);
		if (wallet >= 0)
			System.out.println("Pagamento effettuato correttamente, il tuo nuovo saldo ammonta a " + wallet);
		else
			System.out.println("Pagamento non riuscito, il tuo nuovo saldo ammonta a " + wallet);
	}

	private static float calcolaConto(ArrayList<Pietanza> p) {
		VisualizzaListaPiatti(p);
		System.out.println("Il tuo saldo ammonta a " + utenti.get(loggedID).getSoldi());
		float tot = 0;
		for (int i = 0; i < p.size(); i++)
			tot += p.get(i).getPrezzo();
		System.out.println("Totale ordinazione: " + tot);
		return tot;
	}

	private static void OrdinaPiatto() {
		VisualizzaListaPiatti(piattiOrdinati);
		System.out.println("Inserisci il nome del piatto da ordinare");
		String np = in.nextLine().trim();
		int i = 0;
		boolean trovato = false;
		while (i < piatti.size() && !trovato) {
			if (piatti.get(i).getNome().equalsIgnoreCase(np)) {
				piattiOrdinati.add(piatti.get(i));
				trovato = true;
				System.out.println("Piatto aggiunto alla lista");
			}
			i++;
		}
		if (!trovato)
			System.out.println("Piatto non trovato, controlla la lista");
	}

	private static void VisualizzaListaPiatti(ArrayList<Pietanza> p) {
		System.out.println("\nPiatti presenti:");
		for (int i = 0; i < p.size(); i++) {
			System.out.println(p.get(i));
		}
		
	}

	private static void Register() {
		System.out.println("Inserisci username");
		String username = in.nextLine().trim();
		System.out.println("Inserisci password");
		String password = in.nextLine().trim();
		if (!checkUser(username)){
			utenti.add(new Utente(username, password, id));
			id++;
			System.out.println("Utente creato correttamente");
		}else
			System.out.println("Username già presente nel sistema");
			
	}

	
	private static boolean Login() {
		System.out.println("Inserisci username");
		String user = in.nextLine().trim();
		System.out.println("Inserisci password");
		String pwd = in.nextLine().trim();
		return check(user, pwd);
	}
	
	
	private static boolean check(String user, String pwd) {
		int i = 0;
		boolean found = false;
		boolean login = false;
		while (!found && i < utenti.size()) {
			if (utenti.get(i).getUsername().equals(user)) {
				found = true;
				if (utenti.get(i).getPassword().equals(pwd)) {
					login = true;
					loggedID = i;
				}
			}
			i++;
		}			
		return login;
	}


	private static boolean checkAdmin(String user, String pwd) {
		int i = 0;
		boolean found = false;
		boolean login = false;
		while (!found && i < utenti.size()) {
			if (utenti.get(i).getUsername().equals(user)) {
				found = true;
				if (utenti.get(i).getPassword().equals(pwd) && utenti.get(i).isAdmin()) {
					login = true;
					loggedID = i;
				}
			}
			i++;
		}
		return login;
	}

	private static boolean checkUser(String user) {
		int i = 0;
		boolean found = false;
		while (!found && i < utenti.size()) {
			if (utenti.get(i).getUsername().equals(user))
				found = true;
			i++;
		}
		return found;
	}
	
	
	private static boolean LoginAdmin() {
		System.out.println("Inserisci username");
		String user = in.nextLine().trim();
		System.out.println("Inserisci password");
		String pwd = in.nextLine().trim();
		return checkAdmin(user, pwd);
	}

	
	private static void aggiungiPiatti() {
		piatti.add(new Pietanza("Pasta al pesto", new ArrayList<String>(Arrays.asList("Pasta", "Pesto", "Pecorino")), 12.20f));
		piatti.add(new Pietanza("Pasta al sugo", new ArrayList<String>(Arrays.asList("Pasta", "Sugo", "Parmigiano")), 14f));
		piatti.add(new Pietanza("Pasta al tonno", new ArrayList<String>(Arrays.asList("Pasta", "Tonno", "Pepe")), 15.50f));
	}

}