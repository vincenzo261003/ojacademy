package com.taskCondominio.Gestione.condomini.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskCondominio.Gestione.condomini.models.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {

	Optional<Utente> findByCodiceappartamento(String codiceappartamento);
	
}
