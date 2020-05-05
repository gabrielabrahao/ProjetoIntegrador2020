package com.upf.projetoIntegrador.dao;

import java.util.List;

import com.upf.projetoIntegrador.domain.estoque.Grupo;

public interface GrupoDao {


	  void save(Grupo grupo);
	  
	  void update(Grupo grupo);
	  
	  void delete(Long id);
	  
	  Grupo findByID(Long id);
	  
	  List<Grupo> findAll();
	 
}
