package com.upf.projetoIntegrador.dao;

import java.util.List;

import com.upf.projetoIntegrador.domain.estoque.ProdutosFornecedores;
import com.upf.projetoIntegrador.domain.geral.ClientesFornecedores;

public interface ClientesFornecedoresDao {

	void save(ClientesFornecedores cliente);
	  
	  void update(ClientesFornecedores cliente);
	  
	  void delete(Long id);
	  
	  ClientesFornecedores findByID(Long id);
	  
	  List<ClientesFornecedores> findAll();
	  
	  List<ClientesFornecedores> findAllOrderIdAsc();
	  
	  List<ProdutosFornecedores> findIdFK(Long id);
	  
	  
}
