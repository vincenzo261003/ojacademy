package com.ospedale.Task03.repositories;

import java.util.List;

public interface IDao<T> {

	boolean insert(T t);
	List<T> findAll();
	T findById(Integer id);
	boolean delete(Integer id);
	boolean update(T t);
	
}
