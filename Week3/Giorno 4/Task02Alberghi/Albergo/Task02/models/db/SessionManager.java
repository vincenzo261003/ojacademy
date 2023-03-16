package Albergo.Task02.models.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Albergo.Task02.models.Albergo;
import Albergo.Task02.models.Stanza;

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
    		.addAnnotatedClass(Stanza.class)
    		.addAnnotatedClass(Albergo.class)
    		.buildSessionFactory();
		return sf;
	}
	
}
