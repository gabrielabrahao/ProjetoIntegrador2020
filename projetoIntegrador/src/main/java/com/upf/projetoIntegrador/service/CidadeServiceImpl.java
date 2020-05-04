package com.upf.projetoIntegrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upf.projetoIntegrador.dao.CidadeDao;
import com.upf.projetoIntegrador.domain.geral.Cidades;

@Service
@Transactional(readOnly = false)
public class CidadeServiceImpl implements CidadeService {

	@Autowired
	private CidadeDao dao;

	@Override
	public void salvar(Cidades cidade) {
		dao.save(cidade);

	}

	@Override
	public void editar(Cidades cidade) {
		dao.update(cidade);

	}

	@Override
	public void excluir(long id) {
		dao.delete(id);

	}

	@Override
	public Cidades buscarPorId(Long id) {
		
		return dao.findByID(id);
	}

	@Override
	public List<Cidades> buscarTodos() {
		return dao.findAll();
	}

}
