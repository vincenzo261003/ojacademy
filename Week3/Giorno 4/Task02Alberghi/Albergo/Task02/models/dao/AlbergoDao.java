package Albergo.Task02.models.dao;
import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;

import Albergo.Task02.models.Albergo;
import Albergo.Task02.models.db.SessionManager;


public class AlbergoDao implements IDao<Albergo> {
	
	private static AlbergoDao ogg;
	
	public static AlbergoDao getInstance() {
		if (ogg == null)
			ogg = new AlbergoDao();
		return ogg;
	}
	
	public AlbergoDao() {}

	@Override
	public boolean insert(Albergo t) {
		
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
		
		return !(t.getIdAlbergo() == null);
	}

	@Override
	public List<Albergo> findAll() {
		Session sessione = SessionManager.getInstance().getFactory().getCurrentSession();
		List<Albergo> p = null;
		try {
			sessione.beginTransaction();
			p = sessione.createQuery("FROM Albergo").list();
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
	public Albergo findById(Integer id) {
		Session sessione = SessionManager.getInstance().getFactory().getCurrentSession();
		Albergo temp = null;
		try {
			sessione.beginTransaction();
			
			temp = sessione.get(Albergo.class, id);
			
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
			Albergo temp = sessione.get(Albergo.class, id);
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
	public boolean update(Albergo t) {
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
