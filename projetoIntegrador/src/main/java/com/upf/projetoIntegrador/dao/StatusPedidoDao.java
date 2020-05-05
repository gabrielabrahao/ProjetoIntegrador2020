package com.upf.projetoIntegrador.dao;

import java.util.List;

import com.upf.projetoIntegrador.domain.comercial.StatusPedido;

public interface StatusPedidoDao {
	

	  void save(StatusPedido status);
	  
	  void update(StatusPedido status);
	  
	  void delete(Long id);
	  
	  StatusPedido findByID(Long id);
	  
	  List<StatusPedido> findAll();
	 

}
