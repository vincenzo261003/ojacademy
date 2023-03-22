package com.ospedale.Task03.repositories;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ospedale.Task03.models.Visita;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class VisitaRepository implements IDao<Visita>{
	
	@Autowired
	private EntityManager em;
	
	private Session getSessione() {
		return em.unwrap(Session.class);
	}

	@Override
	@Transactional
	public boolean insert(Visita t) {
		Session sessione = this.getSessione();
		
		try {
			sessione.save(t);
		} catch (Exception e) {
			System.out.println("Errore generico: " + e.getMessage());
		} finally {
			sessione.close();
		}
		
		return !(t.getIdvisita() == null);
	}

	@Override
	@Transactional
	public List<Visita> findAll() {
		Session sessione = this.getSessione();
		List<Visita> p = null;
		try {
			p = sessione.createQuery("FROM Visita").list();
			
		} catch (Exception e) {
			System.out.println("Errore generico: " + e.getMessage());
		} finally {
			sessione.close();
		}
		return p;
	}

	@Override
	@Transactional
	public Visita findById(Integer id) {
		Session sessione = this.getSessione();
		Visita temp = null;
		try {
			temp = sessione.get(Visita.class, id);
			
		} catch (Exception e) {
			System.out.println("Errore generico: " + e.getMessage());
		} finally {
			sessione.clear();
			sessione.close();
		}
		
		return temp;
	}
	
	@Transactional
	public List<Visita> findByCF(String CF) {
		Session sessione = this.getSessione();
		List<Visita> p = null;
		try {
			Query q = sessione.createQuery("FROM Visita WHERE codicefiscale=:n");
			q.setParameter("n", CF);
			p = q.getResultList();
			
		} catch (Exception e) {
			System.out.println("Errore generico: " + e.getMessage());
		} finally {
			sessione.clear();
			sessione.close();
		}
		
		return p;
	}
	
	@Transactional
	public List<Visita> findByDate(Date date) {
		Session sessione = this.getSessione();
		List<Visita> p = null;
		try {
			Query q = sessione.createQuery("FROM Visita WHERE datavisita=:n");
			q.setParameter("n", date);
			p = q.getResultList();
			
		} catch (Exception e) {
			System.out.println("Errore generico: " + e.getMessage());
		} finally {
			sessione.clear();
			sessione.close();
		}
		
		return p;
	}
	
	@Transactional
	public Visita findBySecretCode(String codice, String secret) {
		Session sessione = this.getSessione();
		Visita p = null;
		try {
			Query q = sessione.createQuery("from Visita where codice = :n AND secret = :c");
	        q.setParameter("n", codice);
	        q.setParameter("c", secret);
			p = (Visita)q.getSingleResult();
			
		} catch (Exception e) {
			System.out.println("Errore generico: " + e.getMessage());
		} finally {
			sessione.clear();
			sessione.close();
		}
		
		return p;
	}
	
	@Transactional
	public List<Visita> findByDates(Date dateStart, Date dateEnd) {
		Session sessione = this.getSessione();
		List<Visita> p = null;
		try {
			Query q = sessione.createQuery("FROM Visita WHERE datavisita BETWEEN :x AND :y");
			q.setParameter("x", dateStart);
			q.setParameter("y", dateEnd);
			p = q.getResultList();
			
		} catch (Exception e) {
			System.out.println("Errore generico: " + e.getMessage());
		} finally {
			sessione.clear();
			sessione.close();
		}
		
		return p;
	}

	@Override
	@Transactional
	public boolean delete(Integer id) {
		Session sessione = this.getSessione();
		boolean res = false;
		try {
			Visita temp = sessione.get(Visita.class, id);
			sessione.delete(temp);
			res = true;
			
		} catch (Exception e) {
			System.out.println("Errore generico: " + e.getMessage());
		} finally {
			sessione.close();
		}
		return res;
	}

	@Override
	@Transactional
	public boolean update(Visita t) {
		Session sessione = this.getSessione();
		boolean res = false;
		try {
			sessione.update(t);
			res = true;
			
		} catch (Exception e) {
			System.out.println("Errore generico: " + e.getMessage());
		} finally {
			sessione.close();
		}
		return res;
	}

}
