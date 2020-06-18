package com.upf.projetoIntegrador.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.upf.projetoIntegrador.domain.estoque.Grupo;
import com.upf.projetoIntegrador.service.GrupoService;

@Controller
@RequestMapping("/grupos")
public class GrupoController {

	@Autowired
	GrupoService grupoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Grupo grupo) {
		return "/grupos/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("grupos", grupoService.buscarTodos());
		return "/grupos/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Grupo grupo, RedirectAttributes attr) {
		grupoService.salvar(grupo);
		attr.addFlashAttribute("success", "Grupo inserido com sucesso.");
		return "redirect:/grupos/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("grupo", grupoService.buscarPorId(id));
		return "/grupos/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Grupo grupo, RedirectAttributes attr) {
		grupoService.editar(grupo);
		attr.addFlashAttribute("success", "Grupo editado com sucesso.");
		return "redirect:/grupos/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {

		if (grupoService.grupoTemProdutos(id)) {
			model.addAttribute("fail", "Grupo não removido. Possui produto(s) vinculado(s).");
		} else {
			grupoService.excluir(id);
			model.addAttribute("success", "Grupo excluído com sucesso.");
		}


		return listar(model);
	}
}
