package lez00maven.models.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lez00maven.models.Persona;

public class SessionManager {
	
	private static SessionManager sm;
	private SessionFactory sf;
	
	public static SessionManager getInstance() {
		if (sm == null)
			sm = new SessionManager();
		return sm;
	}
	
	private SessionManager() {
		
	}
	
	public SessionFactory getFactory() {
		if (sf == null)
			sf = new Configuration()
    		.configure("/resources/hibernate.cfg.xml")
    		.addAnnotatedClass(Persona.class)
    		.buildSessionFactory();
		return sf;
	}
	
}
