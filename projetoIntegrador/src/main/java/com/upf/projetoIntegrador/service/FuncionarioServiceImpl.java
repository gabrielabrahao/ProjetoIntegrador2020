package com.upf.projetoIntegrador.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upf.projetoIntegrador.dao.FuncionarioDao;
import com.upf.projetoIntegrador.domain.geral.Funcionario;

@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private FuncionarioDao dao;
	
	
	
	@Override
	public void salvar(Funcionario funcionario) {
		dao.save(funcionario);
	}

	
	@Override
	public void editar(Funcionario funcionario) {
        dao.update(funcionario);	
		
	}

	
	@Override
	public void excluir(long id) {
		dao.delete(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario buscarPorId(Long id) {
		
		return dao.findByID(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscarTodos() {
		
		return dao.findAll();
	}

}