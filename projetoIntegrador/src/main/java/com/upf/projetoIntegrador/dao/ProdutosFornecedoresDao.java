package com.upf.projetoIntegrador.dao;

import java.util.List;


import com.upf.projetoIntegrador.domain.estoque.ProdutosFornecedores;

public interface ProdutosFornecedoresDao {
	
	void save(ProdutosFornecedores fornecedores);
	  
	  void update(ProdutosFornecedores fornecedores);
	  
	  void delete(Long id);
	  
	  ProdutosFornecedores findByID(Long id);
	  
	  List<ProdutosFornecedores> findAll();

}
