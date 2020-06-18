package com.upf.projetoIntegrador.service;

import java.util.List;

import com.upf.projetoIntegrador.domain.estoque.Grupo;



public interface GrupoService {
	
	void salvar(Grupo grupo);

	void editar(Grupo grupo);

	void excluir(long id);

	Grupo buscarPorId(Long id);
	
	Grupo buscarPorDescricao(String text);

	List<Grupo> buscarTodos();

	boolean grupoTemProdutos(Long id);

}
