package com.osvaldo.cruz.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.osvaldo.cruz.model.Perfil;
import com.osvaldo.cruz.model.Vacante;
import com.osvaldo.cruz.repository.PerfilesRepository;
import com.osvaldo.cruz.service.IntPerfilesService;

@Service
@Primary
public class PerfilesServiceJpa implements IntPerfilesService {

	@Autowired
	private PerfilesRepository repoPerfiles;
	
	@Override
	public List<Perfil> obtenerTodas() {
		return repoPerfiles.findAll();
	}

	@Override
	public void guardar(Perfil perfil) {
		repoPerfiles.save(perfil);

	}

	@Override
	public void eliminar(Integer idPerfil) {
		repoPerfiles.deleteById(idPerfil);

	}

	@Override
	public Perfil buscarPorId(Integer idPerfil) {		
		Optional<Perfil> optional = repoPerfiles.findById(idPerfil);
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
