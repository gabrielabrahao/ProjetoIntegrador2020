package com.upf.projetoIntegrador.dao;

import java.util.List;

import com.upf.projetoIntegrador.domain.comercial.PedidoItens;

public interface PedidoItensDao  {

	
	  void save(PedidoItens pedidoItens);
	  
	  void update(PedidoItens pedidoItens);
	  
	  void delete(Long id);
	  
	  PedidoItens findByID(Long id);
	  
	  List<PedidoItens> findAll();
	 
	
}
