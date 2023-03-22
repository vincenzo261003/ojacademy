package com.studente.SpringStudenteRefactor.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studente.SpringStudenteRefactor.models.Studente;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Integer>{

	Optional<Studente> findByMatricola(String varMatr);
	Optional<List<Studente>> findByNominativo(String varNominativo);
	

}
