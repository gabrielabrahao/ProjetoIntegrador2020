package com.upf.projetoIntegrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upf.projetoIntegrador.dao.ClientesFornecedoresDao;
import com.upf.projetoIntegrador.domain.geral.ClientesFornecedores;


/*
 * Ainda Falta implementar para salvar o endereço que ficara em uma tabela auxiliar.
 * 
 */


@Service
public class ClientesFornecedoresServiceImpl  implements ClientesFornecedoresService {
	
	@Autowired
	private ClientesFornecedoresDao daoClientes;

	@Override
	public void salvar(ClientesFornecedores cliente) {
		daoClientes.save(cliente);
		
	}

	@Override
	public void editar(ClientesFornecedores cliente) {
		daoClientes.update(cliente);
		
	}

	@Override
	public void excluir(long id) {
		daoClientes.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public ClientesFornecedores buscarPorId(Long id) {
		return daoClientes.findByID(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ClientesFornecedores> buscarTodos() {
		return daoClientes.findAll();
	}

}
