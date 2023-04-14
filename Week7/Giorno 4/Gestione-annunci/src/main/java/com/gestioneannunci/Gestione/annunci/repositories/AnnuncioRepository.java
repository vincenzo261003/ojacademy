package com.gestioneannunci.Gestione.annunci.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestioneannunci.Gestione.annunci.models.Annuncio;

@Repository
public interface AnnuncioRepository extends JpaRepository<Annuncio, Integer>{

	Optional<Annuncio> findByCodice(String varCodice);

}
