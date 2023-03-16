package Albergo.Task02.models.dao;
import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;

import Albergo.Task02.models.Stanza;
import Albergo.Task02.models.db.SessionManager;


public class StanzaDao implements IDao<Stanza> {
	
	private static StanzaDao ogg;
	
	public static StanzaDao getInstance() {
		if (ogg == null)
			ogg = new StanzaDao();
		return ogg;
	}
	
	public StanzaDao() {}

	@Override
	public boolean insert(Stanza t) {
		
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
		
		return !(t.getIdStanza() == null);
	}

	@Override
	public List<Stanza> findAll() {
		Session sessione = SessionManager.getInstance().getFactory().getCurrentSession();
		List<Stanza> p = null;
		try {
			sessione.beginTransaction();
			p = sessione.createQuery("FROM Stanza").list();
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
	public Stanza findById(Integer id) {
		Session sessione = SessionManager.getInstance().getFactory().getCurrentSession();
		Stanza temp = null;
		try {
			sessione.beginTransaction();
			
			temp = sessione.get(Stanza.class, id);
			
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
			Stanza temp = sessione.get(Stanza.class, id);
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
	public boolean update(Stanza t) {
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
