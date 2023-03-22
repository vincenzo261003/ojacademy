package com.ospedale.Task03.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ospedale.Task03.models.Visita;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Integer> {

}
