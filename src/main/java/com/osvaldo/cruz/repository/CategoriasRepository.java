package com.osvaldo.cruz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osvaldo.cruz.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
