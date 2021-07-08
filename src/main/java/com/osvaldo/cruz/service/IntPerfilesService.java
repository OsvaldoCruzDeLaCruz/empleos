package com.osvaldo.cruz.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.osvaldo.cruz.model.Perfil;
import com.osvaldo.cruz.model.Vacante;

public interface IntPerfilesService {

	public List<Perfil> obtenerTodas();
	public void guardar(Perfil perfil);
	public void eliminar(Integer idPerfil);
	public Perfil buscarPorId(Integer idPerfil);
	
	public Page<Vacante>buscarTodas(Pageable page);
}
