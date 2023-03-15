package lez00maven.models.dao;

import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;

import lez00maven.models.Persona;
import lez00maven.models.db.SessionManager;

public class PersonaDao implements IDao<Persona> {
	
	private static PersonaDao ogg;
	
	public static PersonaDao getInstance() {
		if (ogg == null)
			ogg = new PersonaDao();
		return ogg;
	}
	
	public PersonaDao() {}

	@Override
	public boolean insert(Persona t) {
		
		Session sessione = SessionManager.getInstance().getFactory().getCurrentSession();
		
		try {
			sessione.beginTransaction();
			sessione.save(t);
			sessione.getTransaction().commit();
		} catch (IllegalStateException e) {
			System.out.println("Errore IllegalStateException: " + e.getMessage());
		} catch (RollbackException e) {
			System.out.println("Errore RollbackException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Errore generico: " + e.getMessage());
		} finally {
			sessione.close();
		}
		
		return !(t.getId() == null);
	}

	@Override
	public List<Persona> findAll() {
		Session sessione = SessionManager.getInstance().getFactory().getCurrentSession();
		List<Persona> p = null;
		try {
			sessione.beginTransaction();
			p = sessione.createQuery("FROM Persona").list();
			System.out.println(p);
			
			sessione.getTransaction().commit();
			
		} catch (IllegalStateException e) {
			System.out.println("Errore IllegalStateException: " + e.getMessage());
		} catch (RollbackException e) {
			System.out.println("Errore RollbackException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Errore generico: " + e.getMessage());
		} finally {
			sessione.close();
		}
		return p;
	}

	@Override
	public Persona findById(Integer id) {
		Session sessione = SessionManager.getInstance().getFactory().getCurrentSession();
		Persona temp = null;
		try {
			sessione.beginTransaction();
			
			temp = sessione.get(Persona.class, 13);
			
			sessione.getTransaction().commit();
			
		} catch (IllegalStateException e) {
			System.out.println("Errore IllegalStateException: " + e.getMessage());
		} catch (RollbackException e) {
			System.out.println("Errore RollbackException: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Errore generico: " + e.getMessage());
		} finally {
			sessione.close();
		}
		
		return temp;
	}

	@Override
	public boolean delete(Integer id) {
		Session sessione = SessionManager.getInstance().getFactory().getCurrentSession();
		boolean res = false;
		try {
			sessione.beginTransaction();
			Persona temp = sessione.get(Persona.class, id);
			sessione.delete(temp);
			
			sessione.getTransaction().commit();
			
			res = true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
		return res;
	}

	@Override
	public boolean update(Persona t) {
		Session sessione = SessionManager.getInstance().getFactory().getCurrentSession();
		boolean res = false;
		try {
			sessione.beginTransaction();
			
			sessione.update(t);
			
			sessione.getTransaction().commit();
			
			res = true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sessione.close();
		}
		return res;
	}

}
