package com.upf.projetoIntegrador.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.upf.projetoIntegrador.domain.geral.Cidades;
import com.upf.projetoIntegrador.exceptions.CampoObrigatorioException;
import com.upf.projetoIntegrador.service.CidadeService;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "/home";
	}

	
	
	

}
