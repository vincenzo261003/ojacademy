package models.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

	boolean insert(T t) throws SQLException;
	List<T> findAll() throws SQLException;
	T findById(Integer id) throws SQLException;
	boolean delete(Integer id) throws SQLException;
	boolean update(T t) throws SQLException;
	
}
