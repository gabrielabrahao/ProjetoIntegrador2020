package com.upf.projetoIntegrador.service;

import java.util.List;

import com.upf.projetoIntegrador.domain.geral.ClientesFornecedores;

public interface ClientesFornecedoresService {

	void salvar(ClientesFornecedores cliente);

	void editar(ClientesFornecedores cliente);

	void excluir(long id);

	ClientesFornecedores buscarPorId(Long id);

	List<ClientesFornecedores> buscarTodos();
}
