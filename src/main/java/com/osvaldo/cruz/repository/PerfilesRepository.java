package com.osvaldo.cruz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.osvaldo.cruz.model.Perfil;
import com.osvaldo.cruz.model.Usuario;

public interface PerfilesRepository extends JpaRepository<Perfil, Integer> {
	
	
	Perfil findByPerfil(String Perfil);
	
	@Query(value="select count(*) from Perfiles", nativeQuery=true)
	Integer totalEntidades();

}
