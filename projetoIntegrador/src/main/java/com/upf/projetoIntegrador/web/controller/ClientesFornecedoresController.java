package com.upf.projetoIntegrador.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.upf.projetoIntegrador.domain.UF;
import com.upf.projetoIntegrador.domain.estoque.ProdutosFornecedores;
import com.upf.projetoIntegrador.domain.geral.ClientesFornecedores;
import com.upf.projetoIntegrador.service.ClientesFornecedoresService;
import com.upf.projetoIntegrador.service.ProdutosFornecedoresService;


@Controller
@RequestMapping("/clientes")
public class ClientesFornecedoresController {

	@Autowired
	ClientesFornecedoresService clientesFornecedoresService;

	@Autowired
	ProdutosFornecedoresService fornecedoresService;
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("clientes", clientesFornecedoresService.buscarTodos());
		return "/clientes/lista";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(ClientesFornecedores cliente, ModelMap model) {
		model.addAttribute("cliente", cliente);
		return "/clientes/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(ClientesFornecedores cliente, RedirectAttributes attr) {
		try {
			clientesFornecedoresService.salvar(cliente);
			attr.addFlashAttribute("success", "Cliente inserido com sucesso.");
		} catch (Exception e) {
			attr.addFlashAttribute("fail", e.toString());
		}
		
		return "redirect:/clientes/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cliente", clientesFornecedoresService.buscarPorId(id));
		return "/clientes/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(ClientesFornecedores cliente, RedirectAttributes attr) {
		try {
			clientesFornecedoresService.editar(cliente);
			attr.addFlashAttribute("success", "Cliente editado com sucesso.");
		} catch (Exception e) {
			attr.addFlashAttribute("fail", e.toString());
		}
		
		return "redirect:/clientes/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		
		List<ProdutosFornecedores> lista = fornecedoresService.buscarTodos();
		Boolean adicionado = false;
		
		for (ProdutosFornecedores listaFornecedores : lista) {
			if (listaFornecedores.getFornecedorid().getId() == id) {
				adicionado = true;
				break;
			}
		}
		
		if ( adicionado) {
			model.addAttribute("fail", "Cliente não removido. Possui produtos(s) vinculado(s)."); 
		}else if (clientesFornecedoresService.clienteTemPedidos(id))
		  { 
			  model.addAttribute("fail", "Cliente não removido. Possui pedidos(s) vinculado(s)."); 
		  } else {
			  clientesFornecedoresService.excluir(id);
			  model.addAttribute("success", "Cliente excluído com sucesso.");
			  }
		
		return listar(model);
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}
}
