package main;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		try {
			GestoreProdotto gestore = new GestoreProdotto();
			
//			Prodotto p = new Prodotto("G127", "Gallette", 12, "Alimento", 12f);
//			gestore.Insert(p);
//			System.out.println(p);
			
//			List<Prodotto> elenco = gestore.FindAll();
//			for (Prodotto p: elenco)
//				System.out.println(p);
			
			Prodotto m = gestore.FindByID(7);
			m.setNome("Acqua ferrarelle");
			m.setPrezzo(0.45f);
			
			if (gestore.Update(m))
				System.out.println("Modifica effettuata con successo");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
