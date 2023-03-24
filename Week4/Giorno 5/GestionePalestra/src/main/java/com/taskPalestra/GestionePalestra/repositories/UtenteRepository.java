package com.taskPalestra.GestionePalestra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskPalestra.GestionePalestra.models.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {

}
