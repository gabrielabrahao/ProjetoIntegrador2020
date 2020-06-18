package com.upf.projetoIntegrador.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

	/*
	 * @Autowired ClientesFornecedoresService clientesFornecedoresService;
	 * 
	 * @GetMapping("/listar") public String listar(ModelMap model) {
	 * model.addAttribute("pedidos", clientesFornecedoresService.buscarTodos());
	 * return "/pedidos/lista"; }
	 * 
	 * @GetMapping("/cadastrar") public String cadastrar(ClientesFornecedores
	 * cliente) { return "/pedidos/cadastro"; }
	 * 
	 * @PostMapping("/salvar") public String salvar(ClientesFornecedores cliente,
	 * RedirectAttributes attr) { pedidosFornecedoresService.salvar(cliente);
	 * attr.addFlashAttribute("success", "Cliente inserido com sucesso."); return
	 * "redirect:/pedidos/cadastrar"; }
	 * 
	 * @GetMapping("/editar/{id}") public String preEditar(@PathVariable("id") Long
	 * id, ModelMap model) { model.addAttribute("cliente",
	 * pedidosFornecedoresService.buscarPorId(id)); return "/pedidos/cadastro"; }
	 * 
	 * @PostMapping("/editar") public String editar(ClientesFornecedores cliente,
	 * RedirectAttributes attr) { clientesFornecedoresService.editar(cliente);
	 * attr.addFlashAttribute("success", "Cliente editado com sucesso."); return
	 * "redirect:/pedidos/cadastrar"; }
	 * 
	 * @GetMapping("/excluir/{id}") public String excluir(@PathVariable("id") Long
	 * id, ModelMap model) {
	 * 
	 * 
	 * if (grupoService.grupoTemProdutos(id)) { model.addAttribute("fail",
	 * "Grupo não removido. Possui produto(s) vinculado(s)."); } else {
	 * grupoService.excluir(id); model.addAttribute("success",
	 * "Grupo excluído com sucesso."); }
	 * 
	 * 
	 * clientesFornecedoresService.excluir(id); model.addAttribute("success",
	 * "Cliente excluído com sucesso.");
	 * 
	 * return listar(model); }
	 */
}
