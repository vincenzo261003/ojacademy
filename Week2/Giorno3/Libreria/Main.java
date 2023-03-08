import java.sql.SQLException;
import java.util.List;

import models.Libro;
import models.dao.DaoLibro;

public class Main {

	public static void main(String[] args) {
		DaoLibro dao = new DaoLibro();
		
		try {
			printAll(dao.findAll());
			
			System.out.println();
			
			dao.delete(1);
			dao.delete(2);
			
//			Libro l = new Libro("joewfjoie", "ewfoie", 2000, 23f, "frffe", "243342324");
//			dao.insert(l);
//			printAll(dao.findAll());
//			System.out.println();
			
			Libro l = dao.findById(8);
			l.setDescrizione("ewohfewif");
			
			
			dao.update(l);
			printAll(dao.findAll());
			System.out.println();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void printAll(List<Libro> el) {
		for (Libro l: el)
			System.out.println(l);
	}

}
