package com.lez02.refactor.models.dao;

import java.util.List;

import com.lez02.refactor.models.Studente;

public class StudenteDao implements Dao<Studente>{

	@Override
	public boolean insert(Studente t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Studente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Studente findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Studente t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Studente findByMatricola(String matricola) {
		
		return null;
	}

}
