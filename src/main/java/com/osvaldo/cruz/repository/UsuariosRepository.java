package com.osvaldo.cruz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.osvaldo.cruz.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);
		
	
	@Query(value="select count(*) from Usuarios", nativeQuery=true)
	Integer totalEntidades();
}
