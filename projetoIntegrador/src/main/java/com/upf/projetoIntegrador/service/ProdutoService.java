package com.upf.projetoIntegrador.service;

import java.util.List;

import com.upf.projetoIntegrador.domain.estoque.Produtos;

public interface ProdutoService {

	void salvar(Produtos produto);

	void editar(Produtos produto);

	void excluir(long id);

	Produtos buscarPorId(Long id);

	List<Produtos> buscarTodos();
	
	

	
}
