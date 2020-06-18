package com.upf.projetoIntegrador.service;

import java.util.List;

import com.upf.projetoIntegrador.domain.geral.Funcionario;

public interface FuncionarioService {

	void salvar(Funcionario funcionario);
	
	void editar(Funcionario funcionario);
	
	void excluir(long id);
	
	Funcionario buscarPorId(Long id);
	
	List<Funcionario> buscarTodos();
}
