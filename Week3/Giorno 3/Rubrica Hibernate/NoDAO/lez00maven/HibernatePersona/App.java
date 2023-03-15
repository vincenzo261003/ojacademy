package lez00maven.HibernatePersona;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lez00maven.models.Persona;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = new Configuration()
        		.configure("/resources/hibernate.cfg.xml")
        		.addAnnotatedClass(Persona.class)
        		.buildSessionFactory();
        
        Session sessione = sf.getCurrentSession();
        
        Persona p1 = new Persona("Giovanni", "Pace", "PCA2GNN", "123456", "gio@pace.com");
        Persona p2 = new Persona("Giovanni2", "Pace2", "PCAGNN2", "1234562", "gio@pace.com2");
        Persona p3 = new Persona("Giovanni3", "Pace3", "PCAGNN3", "1234563", "gio@pace.com3");
        
        //INSERT 
        try {
			sessione.beginTransaction();
			sessione.save(p1);
			sessione.save(p2);
			sessione.save(p3);
			sessione.getTransaction().commit();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
        
        //FIND BY ID
        try {
			sessione.beginTransaction();
			
			Persona temp = sessione.get(Persona.class, 13);
			System.out.println(temp);
			
			sessione.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
        
        
        //FIND ALL
        try {
			sessione.beginTransaction();
														//Classe persona -> completamente distaccato dal DBMS (non so come sono fatte le tabelle)
			List<Persona> p = sessione.createQuery("FROM Persona").list();
			System.out.println(p);
			
			sessione.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
        
        
        //DELETE
        try {
			sessione.beginTransaction();
			
			int affRows = sessione.createQuery("DELETE FROM Persona WHERE id = 13").executeUpdate();
			if (affRows > 0)
				System.out.println("Eliminazione effettuata");
			else
				System.out.println("Eliminazione non effettuata");
			
			sessione.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
        
        
        //UPDATE
        try {
			sessione.beginTransaction();
			
			Persona temp = sessione.get(Persona.class, 8);
			temp.setNome("TESTUPDATE");
			temp.setEmail("test@test.com");
			
			sessione.save(temp);
			
			sessione.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
        
    }
}
