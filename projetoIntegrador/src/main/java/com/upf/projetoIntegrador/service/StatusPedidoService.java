package com.upf.projetoIntegrador.service;

import java.util.List;

import com.upf.projetoIntegrador.domain.comercial.StatusPedido;

public interface StatusPedidoService {
	

	void salvar(StatusPedido status);

	void editar(StatusPedido status);

	void excluir(long id);

	StatusPedido buscarPorId(Long id);

	List<StatusPedido> buscarTodos();

}
