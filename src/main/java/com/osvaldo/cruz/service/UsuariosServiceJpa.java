package com.osvaldo.cruz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.osvaldo.cruz.model.Usuario;
import com.osvaldo.cruz.repository.UsuariosRepository;

@Service
public class UsuariosServiceJpa implements IntUsuariosService {

	@Autowired
	private UsuariosRepository repoUsuario;
	@Override
	public List<Usuario> obtenerTodas() {
		 
		return repoUsuario.findAll();
	}

	@Override
	public void guardar(Usuario usuario) {
		repoUsuario.save(usuario);

	}

	@Override
	public void eliminar(Integer idUsuario) {
		 repoUsuario.deleteById(idUsuario);
		 
	}

	@Override
	public Page<Usuario> buscarTodas(Pageable page) {		 
		return repoUsuario.findAll(page);		
	}

	@Override
	public Integer numeroEntidades() {		 
		return repoUsuario.findAll().size();
	}

	@Override
	public Integer calcularTotalEntidades() {
		// TODO Auto-generated method stub
		return repoUsuario.totalEntidades();
	}

}
