package com.lez02.refactor.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lez01.gestore.Prodotto;
import com.lez02.refactor.models.db.ConnettoreDB;

public class ProdottoDao implements Dao<Prodotto>{
	
	private static ProdottoDao proDao;
	
	public static ProdottoDao getIstanza() {
		if(proDao == null)
			proDao = new ProdottoDao();
		
		return proDao;
	}
	
	private ProdottoDao() {
		
	}

	@Override
	public boolean insert(Prodotto t) throws SQLException {
		Connection conn = ConnettoreDB.getIstanza().getConnessione();
		
		String query = "INSERT INTO Prodotto(codice, nome, quantita, categoria, prezzo) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, t.getCodice());
		ps.setString(2, t.getNome());
		ps.setInt(3, t.getQuantita());
		ps.setString(4, t.getCategoria());
		ps.setFloat(5, t.getPrezzo());
		
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		
		Integer idGenerato = rs.getInt(1);
		t.setProdottoID(idGenerato);
		
//		conn.close();
		
		if(idGenerato > 0)
			return true;
		
		return false;
	}

	@Override
	public List<Prodotto> findAll() throws SQLException {
		Connection conn = ConnettoreDB.getIstanza().getConnessione();
		List<Prodotto> elenco = new ArrayList<>();	
		
		String query = "SELECT prodottoID, codice, nome, quantita, categoria, prezzo FROM Prodotto";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Prodotto temp = new Prodotto();
			temp.setProdottoID(rs.getInt(1));
			temp.setCodice(rs.getString(2));
			temp.setNome(rs.getString(3));
			temp.setQuantita(rs.getInt(4));
			temp.setCategoria(rs.getString(5));
			temp.setPrezzo(rs.getFloat(6));
			
			elenco.add(temp);
		}
		
//		conn.close();
		return elenco;
	}

	@Override
	public Prodotto findById(Integer id) throws SQLException {
		Connection conn = ConnettoreDB.getIstanza().getConnessione();
		Prodotto risultato = null;
		
		String query = "SELECT prodottoID, codice, nome, quantita, categoria, prezzo FROM Prodotto WHERE prodottoID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Prodotto temp = new Prodotto();
			temp.setProdottoID(rs.getInt(1));
			temp.setCodice(rs.getString(2));
			temp.setNome(rs.getString(3));
			temp.setQuantita(rs.getInt(4));
			temp.setCategoria(rs.getString(5));
			temp.setPrezzo(rs.getFloat(6));
			
			risultato = temp;
		}
		
//		conn.close();
		
		return risultato;
	}

	@Override
	public boolean delete(Integer id)  throws SQLException{
		Connection conn = ConnettoreDB.getIstanza().getConnessione();

		String query = "DELETE FROM Prodotto WHERE prodottoID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		
		int affRows = ps.executeUpdate();
		
//		conn.close();
		if(affRows > 0)
			return true;

		return false;
	}

	@Override
	public boolean update(Prodotto t)  throws SQLException{
		Connection conn = ConnettoreDB.getIstanza().getConnessione();
		String query = "UPDATE Prodotto SET "
				+ "codice = ?, "
				+ "nome = ?, "
				+ "quantita = ?, "
				+ "categoria = ?, "
				+ "prezzo = ? "
				+ "WHERE prodottoID = ?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, t.getCodice());
		ps.setString(2, t.getNome());
		ps.setInt(3, t.getQuantita());
		ps.setString(4, t.getCategoria());
		ps.setFloat(5, t.getPrezzo());
		ps.setInt(6, t.getProdottoID());
		
		int affRows = ps.executeUpdate();
//		conn.close();
		if(affRows > 0)
			return true;

		return false;
	}

}
