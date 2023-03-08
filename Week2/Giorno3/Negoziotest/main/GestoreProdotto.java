package main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.MysqlDataSource;

public class GestoreProdotto {
	private MysqlDataSource dataSource;
	
	public GestoreProdotto() throws SQLException {
		dataSource = new MysqlDataSource();
		dataSource.setServerName("localhost");
		dataSource.setPortNumber(3306);
		dataSource.setUser("root");
		dataSource.setPassword("toor");
		dataSource.setDatabaseName("prodotto");
		dataSource.setUseSSL(false);
		dataSource.setAllowPublicKeyRetrieval(true);
	}
	
	public boolean Insert(Prodotto p) throws SQLException {
		Connection conn = dataSource.getConnection();
		
		String query = "INSERT INTO Prodotto(codice, nome, quantita, categoria, prezzo) VALUE (?, ?, ?, ?, ?);";
		PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		ps.setString(1, p.getCodice());
		ps.setString(2, p.getNome());
		ps.setInt(3, p.getQuantita());
		ps.setString(4, p.getCategoria());
		ps.setFloat(5, p.getPrezzo());
		
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		
		Integer idGenerato = rs.getInt(1);
		p.setProdottoID(idGenerato); //Funziona perché come parametro ho il riferimento dell'obj prodotto invece che il clone
		
		conn.close();
		
		return idGenerato > 0;
	}
	
	
	public List<Prodotto> FindAll() throws SQLException{
		Connection conn = dataSource.getConnection();
		List<Prodotto> elenco = new ArrayList<>();
		
		String query = "SELECT prodottoID, codice, nome, quantita, categoria, prezzo FROM Prodotto";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery(); 
		
		while(rs.next()){
			Prodotto temp = new Prodotto(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getFloat(6));
			temp.setProdottoID(rs.getInt(1));
			elenco.add(temp);
		}
		
		conn.close();
		return elenco;
	}
	
	public Prodotto FindByID(int x) throws SQLException{
		Connection conn = dataSource.getConnection();

		String query = "SELECT prodottoID, codice, nome, quantita, categoria, prezzo FROM Prodotto WHERE prodottoID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, x);
		
		ResultSet rs = ps.executeQuery(); 
		Prodotto temp = null;
		
		while(rs.next()){
			temp = new Prodotto(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getFloat(6));
			temp.setProdottoID(rs.getInt(1));
		}
		
		conn.close();
		return temp;
	}
	
	public boolean Delete(int x) throws SQLException{
		Connection conn = dataSource.getConnection();

		String query = "DELETE FROM Prodotto WHERE prodottoID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, x);
		
		int affRows = ps.executeUpdate(); 
		
		conn.close();
		return affRows > 0;
	}
	
	public boolean Update(Prodotto p) throws SQLException{
		Connection conn = dataSource.getConnection();

		String query = "UPDATE Prodotto SET "
				+ "codice = ?, "
				+ "nome = ?, "
				+ "quantita = ?, "
				+ "categoria = ?, "
				+ "prezzo = ? "
				+ "WHERE prodottoID = ?";		
		
		PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		ps.setString(1, p.getCodice());
		ps.setString(2, p.getNome());
		ps.setInt(3, p.getQuantita());
		ps.setString(4, p.getCategoria());
		ps.setFloat(5, p.getPrezzo());
		ps.setInt(6, p.getProdottoID());
		
		int affRows = ps.executeUpdate();
		
		conn.close();
		return affRows > 0;
	}
}
