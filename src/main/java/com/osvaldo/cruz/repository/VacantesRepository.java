package com.osvaldo.cruz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osvaldo.cruz.model.Vacante;

import java.util.List;

public interface VacantesRepository extends JpaRepository<Vacante, Integer>{
	List<Vacante> findByEstatus(String estatus);
	
	
	List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(int destacado, String estatus);
	
}