import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Main {

	public static void main(String[] args) {
		//Connection conn = null; //Inizializzo per accedere al metodo close nel finally
		
		try {
			//Dati connessione (JDBC)
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");
			dataSource.setPortNumber(3306);
			dataSource.setUser("root");
			dataSource.setPassword("toor");
			dataSource.setDatabaseName("prodotto");
			dataSource.setUseSSL(false);
			dataSource.setAllowPublicKeyRetrieval(true);
			
			//Connessione (Java.SQL)
			Connection conn = dataSource.getConnection();
			System.out.println("[INFO] Sono connesso");
			
			
			
			
			//INSERIMENTO - DML
			
			String codice = "AC12345";
			String nome = "Acqua";
			Integer quantita = 15;
			String categoria = "Bevanda";
			Float prezzo = 0.36f;
			
			String query = "INSERT INTO Prodotto(codice, nome, quantita, categoria, prezzo) VALUE (?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			//Setto i parametri
			ps.setString(1, codice);
			ps.setString(2, nome);
			ps.setInt(3, quantita);
			ps.setString(4, categoria);
			ps.setFloat(5, prezzo);
			
			//Eseguo l'operazione DML e ottengo il numero di righe affette
			int affRows = ps.executeUpdate();
			
			if (affRows > 0)
				System.out.println("[INFO] Inserimento effettuato");
			else
				System.out.println("[ERR] Inserimento non riuscito");
			
			//Creo un result set con i dati presi dal ps
			ResultSet rs = ps.getGeneratedKeys();
			rs.next(); //Provo a prendere un elemento 
			
			Integer idGenerato = rs.getInt(1); //Ottengo l'intero alla colonna uno (in questo caso l'id AI)
			
			if (idGenerato > 0)
				System.out.println("[INFO] Inserimento effettuato con id " + idGenerato);
			else
				System.out.println("[ERR] Inserimento non riuscito");
		
			
			
			
			//SELECT - QL
			
			//Evito di utilizzare * in modo da evitare problemi in caso di riposizionamento delle colonne
			String query = "SELECT prodottoID, codice, nome, quantita, categoria, prezzo FROM Prodotto";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery(); //Utilizzato per il QL
			while(rs.next()){
				Integer prodottoID = rs.getInt(1);
				String codice = rs.getString(2);
				String nome = rs.getString(3);
				Integer quantita = rs.getInt(4);
				String categoria = rs.getString(5);
				Float prezzo = rs.getFloat(6);
				
				System.out.println(prodottoID + " " + codice + " " + nome);
			}
			
			
			
			
			//DELETE - QML
			
			Integer id = 2;
			String query = "DELETE FROM Prodotto WHERE prodottoID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			int affRows = ps.executeUpdate();
			if (affRows > 0)
				System.out.println("[INFO] Eliminazione effettuata");
			else
				System.out.println("[ERR] Eliminazione non effettuata");
			
			
			
			
			//UPDATE - QML
			Integer id = 3;
			String query = "UPDATE Prodotto SET "
					+ "codice = ?, "
					+ "nome = ?, "
					+ "quantita = ?, "
					+ "categoria = ?, "
					+ "prezzo = ? "
					+ "WHERE prodottoID = ?";
			
			PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			//Setto i parametri
			ps.setString(1, "23WFUEF");
			ps.setString(2, "Coca cola");
			ps.setInt(3, 4);
			ps.setString(4, "Bevande");
			ps.setFloat(5, 3f);
			ps.setInt(6, id);
			
			int affRows = ps.executeUpdate();
			if (affRows > 0)
				System.out.println("[INFO] Modifica effettuata");
			else
				System.out.println("[ERR] Modifica non effettuata");
			
			
		}catch(SQLException e) {
			System.out.println("[ERR] Errore SQL: " + e.getMessage());
		}catch(Exception e) {
			System.out.println("[ERR] Errore generico: " + e.getMessage());
		}finally {
			//conn.close();
		}
		
	}

}
