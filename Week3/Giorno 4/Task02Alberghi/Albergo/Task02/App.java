package Albergo.Task02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import Albergo.Task02.models.Albergo;
import Albergo.Task02.models.Stanza;
import Albergo.Task02.models.dao.AlbergoDao;
import Albergo.Task02.models.dao.StanzaDao;

public class App 
{
    public static void main( String[] args )
    {
//        Albergo a1 = new Albergo("Albergone", "albergone@gmail.com", "+21 1234567890", 5); 
//        
//        Stanza s1 = new Stanza("Stanzone", "SZ1234", false);
//        s1.setStruttura(AlbergoDao.getInstance().findById(1));
//        
//        try {
//			AlbergoDao.getInstance().insert(a1);
//			StanzaDao.getInstance().insert(s1);
//		} catch (Exception e) {
//			System.out.println("Errore: " + e.getMessage());
//		}
        
//        System.out.println(AlbergoDao.getInstance().findAll());
//        System.out.println();
//        System.out.println(StanzaDao.getInstance().findAll());
    	
    	//System.out.println(esportazione());
    	
        esporta();
    }
    
    public static void esporta() {
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");  
	    LocalDateTime now = LocalDateTime.now();  
    	
    	try {
	      File myObj = new File("Esportazioni/Esportazione_" + dtf.format(now) + ".txt");
	      myObj.createNewFile();
	      
	      FileWriter myWriter = new FileWriter(myObj.getName());
	      myWriter.write(generaEsportazione());
	      myWriter.close();
	      System.out.println("Esportazione eseguita correttamente");
	      
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
    }
    
    
    public static String generaEsportazione() {
    	String res = "";
    	
    	ArrayList<Stanza> stanze = (ArrayList<Stanza>) StanzaDao.getInstance().findAll();
    	
    	for (Stanza x: stanze)
    		res += x.getNome() + ", " + x.getCodice() + ", " + ((x.isStatoOccupazione()) ? "Occupata\n" : "Libera\n");
    	
    	return res;
    }
}
