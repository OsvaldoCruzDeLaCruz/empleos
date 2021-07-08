package com.osvaldo.cruz.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.osvaldo.cruz.model.Perfil;
import com.osvaldo.cruz.model.Usuario;
import com.osvaldo.cruz.model.Vacante;
import com.osvaldo.cruz.service.IntUsuariosService;
import com.osvaldo.cruz.service.IntVacantesService;

@Controller
public class HomeController {
	
	@Autowired
	private IntUsuariosService usuarioService;
	
	@Autowired
	private IntVacantesService vacantesService;

	@PostMapping("/guardar")
	public String guardarUsuario(Usuario usuario) {
		
		usuario.setEstatus(1);
		usuario.setFechaRegistro(LocalDate.now());
		
//		Por defecto es Usuario
		
		Perfil per = new Perfil();
		per.setId(3);
		usuario.agregar(per);
		usuarioService.guardar(usuario);
		return "formLogin";
		
		
		
	}
	
	@GetMapping("/registro")
	public String registroUsuario(Usuario usuario) {
		return "formRegistro";
	}
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		List<Vacante> vacantes = vacantesService.obtenerDestacadas();
		model.addAttribute("vacantes",vacantes);		
		return "home";
	}

}
