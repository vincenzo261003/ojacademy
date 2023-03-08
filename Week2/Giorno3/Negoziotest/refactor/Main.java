package com.lez02.refactor;

import java.sql.SQLException;

import com.lez01.gestore.Prodotto;
import com.lez02.refactor.models.dao.ProdottoDao;
import com.lez02.refactor.models.db.ConnettoreDB;

public class Main {

	public static void main(String[] args) {

		Prodotto proUno = new Prodotto("PR1", "Prodotto 1", 12, "Alimento", 1.99f);
		Prodotto proDue = new Prodotto("PR2", "Prodotto 2", 12, "Alimento", 1.99f);
		Prodotto proTre = new Prodotto("PR3", "Prodotto 3", 12, "Alimento", 1.99f);

		try {
			proDao.getIstanza().insert(proUno);
			proDao.insert(proDue);
			proDao.insert(proTre);
			
			System.out.println("STAPPOOOOOOOO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
