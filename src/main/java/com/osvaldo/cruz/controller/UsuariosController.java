package com.osvaldo.cruz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.osvaldo.cruz.model.Usuario;
import com.osvaldo.cruz.service.IntUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private IntUsuariosService usuarioService;
	
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("id")int idUsuario,
			RedirectAttributes atributo) {
		usuarioService.eliminar(idUsuario);
		atributo.addFlashAttribute("msg", "Usuario eliminado");
		return "redirect:/usuarios/indexPaginado";
	}
	
	@GetMapping(value = "/indexPaginado")
	public String mostrarIndexPaginado(Model model, Pageable page) {
	Page<Usuario>lista = usuarioService.buscarTodas(page);
	model.addAttribute("usuarios", lista);
	model.addAttribute("total", usuarioService.calcularTotalEntidades());
	return "usuarios/listaUsuarios";
	}
	
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Usuario> lista = usuarioService.obtenerTodas();
		model.addAttribute("usuarios", lista);
		return "usuarios/listaUsuarios";
	}
	
}
