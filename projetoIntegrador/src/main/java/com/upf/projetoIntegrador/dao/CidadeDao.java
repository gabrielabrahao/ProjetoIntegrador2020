package com.upf.projetoIntegrador.dao;

import java.util.List;

import com.upf.projetoIntegrador.domain.geral.Cidades;

public interface  CidadeDao {


	void save(Cidades cidade);
	
	void update(Cidades cidade);
	
	void delete(Long id);
	
	Cidades findByID(Long id);
	
	List<Cidades> findAll();
}
