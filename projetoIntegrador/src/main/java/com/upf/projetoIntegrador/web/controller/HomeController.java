package com.upf.projetoIntegrador.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.upf.projetoIntegrador.domain.geral.Cidades;
import com.upf.projetoIntegrador.service.CidadeService;

@Controller
public class HomeController {
	
	
 
	@GetMapping("/")
	public String home() {
		return "/home";
	}
	
	
	///Controles de Cidade
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("cidade/cadastro")
	public String cadastrar() {
		return "/cidade/cadastro";
	}
	
	
	@GetMapping("cidade/lista")
	public String listar() {
		return "/cidade/lista";
		}
	
	@PostMapping("cidade/salvar")
	public String salvar(Cidades cidade) {
		cidadeService.salvar(cidade);
		return "redirect:/cidade/cadastro";
	}
	
	
	
}
