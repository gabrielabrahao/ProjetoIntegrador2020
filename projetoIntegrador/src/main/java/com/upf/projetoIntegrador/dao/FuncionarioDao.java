package com.upf.projetoIntegrador.dao;

import java.util.List;

import com.upf.projetoIntegrador.domain.geral.Funcionario;

public interface FuncionarioDao {

	void save(Funcionario funcionario);
	
	void update(Funcionario funcionario);
	
	void delete(Long id);
	
	Funcionario findByID(Long id);
	
	List<Funcionario> findAll();
}
