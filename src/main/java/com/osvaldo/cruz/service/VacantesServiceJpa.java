package com.osvaldo.cruz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.osvaldo.cruz.model.Vacante;
import com.osvaldo.cruz.repository.VacantesRepository;

@Service
@Primary
public class VacantesServiceJpa implements IntVacantesService{

	@Autowired
	private VacantesRepository repoVacantes;
	
	@Override
	public List<Vacante> obtenerTodas() {
		 
		return repoVacantes.findAll();
	}

	@Override
	public void guardar(Vacante vacante) {
		 repoVacantes.save(vacante);
		
	}

	@Override
	public void eliminar(Integer idVacante) {
		 repoVacantes.deleteById(idVacante);
		
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		 Optional<Vacante> optional = repoVacantes.findById(idVacante);
		 if(optional.isPresent()) {
			 return optional.get();
		 }
		return null;
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		return repoVacantes.findAll(page);
	}

	@Override
	public List<Vacante> obtenerDestacadas() {
		   
		return repoVacantes.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
	}
	
	
	
	
}