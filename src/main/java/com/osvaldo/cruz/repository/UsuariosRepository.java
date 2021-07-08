package com.osvaldo.cruz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osvaldo.cruz.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
