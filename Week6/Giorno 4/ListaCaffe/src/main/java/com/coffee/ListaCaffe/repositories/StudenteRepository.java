package com.coffee.ListaCaffe.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.ListaCaffe.models.Studente;

public interface StudenteRepository extends JpaRepository<Studente, Integer> {

	Optional<Studente> findByCodice(String varCodice);

}
