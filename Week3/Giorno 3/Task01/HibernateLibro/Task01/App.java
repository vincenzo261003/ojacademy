package HibernateLibro.Task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import HibernateLibro.models.Libro;
import HibernateLibro.models.dao.LibroDao;

public class App 
{
	public static void main( String[] args ) {
    	inserisciLibriCsv("src/main/java/csv/libro.csv");
    	System.out.println(LibroDao.getInstance().findAll());
    }
    
    public static ArrayList<String> leggiFile(String path) {
    	File file = new File(path);
    	ArrayList<String> elenco = new ArrayList<String>();
        try {
        	BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
			while ((st = br.readLine()) != null) {
				elenco.add(st);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        return elenco;
    }
    
    public static Libro creaLibro(String riga) {
    	
    	int inizioDescrizione = riga.indexOf("\"");
    	int fineDescrizione = riga.lastIndexOf("\"");
    	
    	String[] secondaParte = riga.substring(fineDescrizione+1).split(",");
    	String titolo = riga.substring(0, inizioDescrizione-1);
    	String descrizione = riga.substring(inizioDescrizione+1, fineDescrizione);
    	String autore = secondaParte[1];
    	String data_pubblicazione = secondaParte[2];
    	String isbn = secondaParte[3];
    	Float prezzo = Float.parseFloat(secondaParte[4]);
    	String casa_editrice = secondaParte[5];
    	
    	System.out.println(new Libro(titolo, descrizione, autore, data_pubblicazione, isbn, casa_editrice, prezzo));
    	
    	return new Libro(titolo, descrizione, autore, data_pubblicazione, isbn, casa_editrice, prezzo);
    }
    
    public static boolean inserisciLibriCsv(String path) {
    	ArrayList<String> righe = leggiFile(path);
    	boolean verifica = true;
    	for(String riga:righe) {
    		Libro temp = creaLibro(riga);
    		verifica = LibroDao.getInstance().insert(temp);
    		System.out.println(verifica);
    		if (!verifica)
    			return false;
    	}
    	return true;
    }
}
