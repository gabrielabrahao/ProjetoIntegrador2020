package com.upf.projetoIntegrador.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.upf.projetoIntegrador.domain.geral.Cidades;


public interface CidadeService {

	void salvar(Cidades cidade )  ;

	void editar(Cidades cidade);

	void excluir(long id);

	Cidades buscarPorId(Long id);

	List<Cidades> buscarTodos();
	
	//boolean cidadestem
}
