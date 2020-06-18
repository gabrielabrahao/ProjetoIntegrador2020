package com.upf.projetoIntegrador.service;

import java.util.List;

import com.upf.projetoIntegrador.domain.estoque.ProdutosFornecedores;


public interface ProdutosFornecedoresService {
	
	void salvar( Long idProduto, Long idFornecedor)  ;

	void editar(ProdutosFornecedores fornecedores);

	void excluir(long id);

	ProdutosFornecedores buscarPorId(Long id);

	List<ProdutosFornecedores> buscarTodos();
	

}
