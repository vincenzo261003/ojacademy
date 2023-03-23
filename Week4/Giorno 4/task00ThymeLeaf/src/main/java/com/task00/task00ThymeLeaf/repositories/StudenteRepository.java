package com.task00.task00ThymeLeaf.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.task00.task00ThymeLeaf.models.Studente;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Integer> {
	
	List<Studente> findByMatricola(String m);
	
}
