package com.upf.projetoIntegrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upf.projetoIntegrador.dao.StatusPedidoDao;
import com.upf.projetoIntegrador.domain.comercial.StatusPedido;

@Service
public class StatusPedidoServiceImpl implements StatusPedidoService {

	@Autowired
	private StatusPedidoDao dao;
	
	@Override
	public void salvar(StatusPedido status) {
		dao.save(status);
		
	}

	@Override
	public void editar(StatusPedido status) {
		dao.update(status);
		
	}

	@Override
	public void excluir(long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public StatusPedido buscarPorId(Long id) {
		return dao.findByID(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<StatusPedido> buscarTodos() {
		return dao.findAll();
	}

}
