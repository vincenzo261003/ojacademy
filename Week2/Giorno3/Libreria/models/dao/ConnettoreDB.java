package models.dao;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnettoreDB {

	private static ConnettoreDB connettore;
	private Connection connessione;
	
	public static ConnettoreDB getIstanza() {
		if(connettore == null)
			connettore = new ConnettoreDB();
		
		return connettore;
	}
	
	private ConnettoreDB() {
		
	}
	
	public Connection getConnessione() throws SQLException {
		
		if(connessione == null) {
			MysqlDataSource dataSource = new MysqlDataSource();
			
			dataSource.setServerName("localhost");
			dataSource.setPortNumber(3306);
			dataSource.setUser("root");
			dataSource.setPassword("toor");
			dataSource.setDatabaseName("libreria");
			dataSource.setUseSSL(false);
			dataSource.setAllowPublicKeyRetrieval(true);
			
			connessione = dataSource.getConnection();
		}
		
		return connessione;
	}

}
