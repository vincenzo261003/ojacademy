package HibernateLibro.models.dao;
import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;

import HibernateLibro.models.Libro;
import HibernateLibro.models.db.SessionManager;

public class LibroDao implements IDao<Libro> {
	
	private static LibroDao ogg;
	
	public static LibroDao getInstance() {
		if (ogg == null)
			ogg = new LibroDao();
		return ogg;
	}
	
	public LibroDao() {}

	@Override
	public boolean insert(Libro t) {
		
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
	public List<Libro> findAll() {
		Session sessione = SessionManager.getInstance().getFactory().getCurrentSession();
		List<Libro> p = null;
		try {
			sessione.beginTransaction();
			p = sessione.createQuery("FROM Libro").list();
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
	public Libro findById(Integer id) {
		Session sessione = SessionManager.getInstance().getFactory().getCurrentSession();
		Libro temp = null;
		try {
			sessione.beginTransaction();
			
			temp = sessione.get(Libro.class, 13);
			
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
			Libro temp = sessione.get(Libro.class, id);
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
	public boolean update(Libro t) {
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
