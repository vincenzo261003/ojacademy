package com.taskCondominio.Gestione.condomini.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskCondominio.Gestione.condomini.models.Condominio;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Integer>{

	Optional<Condominio> findByCodice(String varCondominio);
	
}
