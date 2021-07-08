package com.osvaldo.cruz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@GetMapping("/index")
	public String mostrarIndex() {
		return "usuarios/listaUsuarios";
	}
	
}
