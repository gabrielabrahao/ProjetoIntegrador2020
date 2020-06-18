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

import com.upf.projetoIntegrador.domain.estoque.Grupo;
import com.upf.projetoIntegrador.domain.estoque.Produtos;
import com.upf.projetoIntegrador.domain.estoque.ProdutosFornecedores;
import com.upf.projetoIntegrador.domain.geral.ClientesFornecedores;
import com.upf.projetoIntegrador.service.ClientesFornecedoresService;
import com.upf.projetoIntegrador.service.GrupoService;
import com.upf.projetoIntegrador.service.ProdutoService;
import com.upf.projetoIntegrador.service.ProdutosFornecedoresService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	@Autowired
	GrupoService grupoService;
	@Autowired
	ClientesFornecedoresService clientesService;

	@Autowired
	ProdutosFornecedoresService fornecedoresService;

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("produtos", produtoService.buscarTodos());
		return "/produtos/lista";
	}

	@GetMapping("/cadastrar")
	public String cadastrar(Produtos produto, ModelMap model) {
		model.addAttribute("produto", produto);
		return "/produtos/cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(Produtos produto, RedirectAttributes attr) {
		produtoService.salvar(produto);
		attr.addFlashAttribute("success", "Produto inserido com sucesso.");
		return "redirect:/produtos/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("produto", produtoService.buscarPorId(id));
		// model.addAttribute("produtoFornecedores",
		// produtoService.buscarPorId(id).getProdutosFornecedores());

		return "/produtos/cadastro";
	}

	@GetMapping("/fornecedor/{forn}/{prod}")
	public String GravarFornecedor(@PathVariable("forn") Long idFornecedor, @PathVariable("prod") Long idProduto,
			Produtos produto, ModelMap model) {
		List<ProdutosFornecedores> lista = listaDeFornecedoresSalvo();
		boolean adicionado = false;
		
		/*
		 * for (int i = 0; i < lista.size(); i++) { lista }
		 */

		for (ProdutosFornecedores prodForne : lista) {

			if (prodForne.getFornecedorid().getId() == idFornecedor && prodForne.getProdutoid().getId() == idProduto) {
				
					adicionado = true;
				
			}

		}

		if (adicionado) {
			model.addAttribute("fail", " Fornecedor já adicionado.");
		} else if (idFornecedor == null || idFornecedor == 0) {
			model.addAttribute("fail", " Fornecedor não selecionado na combo.");
		} else {
			fornecedoresService.salvar(idProduto, idFornecedor);
			model.addAttribute("produto", produto);
			model.addAttribute("success", " Fornecedor adicionado com sucesso.");
		}

		return preEditar(idProduto, model);
	}

	@GetMapping("/fornecedor/excluir/{id}")
	public String excluirFornecedor(@PathVariable("id") Long id, ModelMap model) {

		ProdutosFornecedores o = fornecedoresService.buscarPorId(id);

		fornecedoresService.excluir(id);
		// produtoService.excluir(id);
		model.addAttribute("success", " Fornecedor removido com sucesso.");

		return preEditar(o.getProdutoid().getId(), model);
	}

	@PostMapping("/editar")
	public String editar(Produtos produto, RedirectAttributes attr) {
		/*
		 * if (produto.getProdutosFornecedores().isEmpty()) {
		 * produto.setProdutosFornecedores(null); }
		 */
		produtoService.editar(produto);
		attr.addFlashAttribute("success", "Produto editado com sucesso.");
		return "redirect:/produtos/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {

		/*
		 * if (grupoService.grupoTemProdutos(id)) { model.addAttribute("fail",
		 * "Grupo não removido. Possui produto(s) vinculado(s)."); } else {
		 * grupoService.excluir(id); model.addAttribute("success",
		 * "Grupo excluído com sucesso."); }
		 */

		produtoService.excluir(id);
		model.addAttribute("success", "Produto excluído com sucesso.");

		return listar(model);
	}

	@ModelAttribute("grupos")
	public List<Grupo> listaDeGrupos() {
		return grupoService.buscarTodos();
	}

	@ModelAttribute("fornecedores")
	public List<ClientesFornecedores> listaDeFornecedores() {
		return clientesService.buscarTodos();
	}

	// @ModelAttribute("fornecedoresDoProduto")
	public List<ProdutosFornecedores> listaDeFornecedoresSalvo() {

		return fornecedoresService.buscarTodos();
	}

}
