
public class Main {

	public static void main(String[] args) {
		Gestorefile gestore = new Gestorefile();
		
		if(gestore.scriviFileNormale("test1.txt", "prova"))
			System.out.println("Scrittura avvenuta con successo");
		else
			System.out.println("Scrittura non riuscita");
		
		if(gestore.scriviFileNormale("test2.txt", "prova2"))
			System.out.println("Scrittura avvenuta con successo");
		else
			System.out.println("Scrittura non riuscita");
		
		System.out.println(gestore.leggiFile("test1.txt"));
	}

}
