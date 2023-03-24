package com.taskPalestra.GestionePalestra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskPalestra.GestionePalestra.models.Corso;

@Repository
public interface CorsoRepository extends JpaRepository<Corso, Integer> {

}
