package lez01maven.HibernatePersona;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lez00maven.models.Persona;
import lez00maven.models.dao.PersonaDao;

public class App 
{
    public static void main( String[] args ){
        
        Persona p1 = new Persona("Giovanni", "Pace", "PCA2GNNbg", "123456", "gio@pace.com");
        
        if(PersonaDao.getInstance().insert(p1))
        	System.out.println("Ok");
        else 
        	System.out.println("Ko");
        
    }
}

