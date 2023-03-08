package models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Libro;

public class DaoLibro implements Dao<Libro>{
	
	private static DaoLibro libroDao;
	
	public static DaoLibro getIstanza() {
		if (libroDao == null)
			libroDao = new DaoLibro();
		return libroDao;
	}
	
	public DaoLibro() {
		
	}

	@Override
	public boolean insert(Libro t) throws SQLException {
		Connection conn = ConnettoreDB.getIstanza().getConnessione();
		
		String query = "INSERT INTO libro(titolo, descrizione, dataPubblicazione, prezzo, autore, ISBN) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, t.getTitolo());
		ps.setString(2, t.getDescrizione());
		ps.setInt(3, t.getAnnoPubblicazione());
		ps.setFloat(4, t.getPrezzo());
		ps.setString(5, t.getAutore());
		ps.setString(6, t.getISBN());
		
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		
		Integer idGenerato = rs.getInt(1);
		t.setIdLibro(idGenerato);
		
		return idGenerato > 0;
	}

	@Override
	public List<Libro> findAll() throws SQLException {
		Connection conn = ConnettoreDB.getIstanza().getConnessione();
		List<Libro> elenco = new ArrayList<>();	
		
		String query = "SELECT idLibro, titolo, descrizione, dataPubblicazione, prezzo, autore, ISBN FROM libro";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Libro temp = new Libro();
			temp.setIdLibro(rs.getInt(1));
			temp.setTitolo(rs.getString(2));
			temp.setDescrizione(rs.getString(3));
			temp.setAnnoPubblicazione(rs.getInt(4));
			temp.setPrezzo(rs.getFloat(5));
			temp.setAutore(rs.getString(6));
			temp.setISBN(rs.getString(7));
			
			elenco.add(temp);
		}
		
		return elenco;
	}

	@Override
	public Libro findById(Integer id) throws SQLException {
		Connection conn = ConnettoreDB.getIstanza().getConnessione();
		Libro risultato = null;
		
		String query = "SELECT idLibro, titolo, descrizione, dataPubblicazione, prezzo, autore, ISBN FROM libro WHERE idLibro = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Libro temp = new Libro();
			temp.setIdLibro(rs.getInt(1));
			temp.setTitolo(rs.getString(2));
			temp.setDescrizione(rs.getString(3));
			temp.setAnnoPubblicazione(rs.getInt(4));
			temp.setPrezzo(rs.getFloat(5));
			temp.setAutore(rs.getString(6));
			temp.setISBN(rs.getString(7));
			
			risultato = temp;
		}
		
		return risultato;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		Connection conn = ConnettoreDB.getIstanza().getConnessione();

		String query = "DELETE FROM libro WHERE idLibro = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		
		int affRows = ps.executeUpdate();

		return affRows > 0;
	}

	@Override
	public boolean update(Libro t) throws SQLException {
		Connection conn = ConnettoreDB.getIstanza().getConnessione();
		String query = "UPDATE libro SET "
				+ "titolo = ?, "
				+ "descrizione = ?, "
				+ "dataPubblicazione = ?, "
				+ "prezzo = ?, "
				+ "autore = ?, "
				+ "ISBN = ? "
				+ "WHERE idLibro = ?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, t.getTitolo());
		ps.setString(2, t.getDescrizione());
		ps.setInt(3, t.getAnnoPubblicazione());
		ps.setFloat(4, t.getPrezzo());
		ps.setString(5, t.getAutore());
		ps.setString(6, t.getISBN());
		ps.setInt(7, t.getIdLibro());
		
		int affRows = ps.executeUpdate();
		return affRows > 0;
	}
	
}
