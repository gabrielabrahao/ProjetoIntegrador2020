package com.upf.projetoIntegrador.dao;

import java.util.List;

import com.upf.projetoIntegrador.domain.estoque.Produtos;

public interface ProdutosDao {

	 void save(Produtos produtos);
	  
	  void update(Produtos produtos);
	  
	  void delete(Long id);
	  
	  Produtos findByID(Long id);
	  
	  List<Produtos> findAll();
}
