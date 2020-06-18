package com.upf.projetoIntegrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upf.projetoIntegrador.dao.ProdutosDao;
import com.upf.projetoIntegrador.domain.estoque.Produtos;

@Service
@Transactional(readOnly = false) // Essa informação é implicita, informado apenas para conhecimento
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutosDao dao;

	@Override
	public void salvar(Produtos produto) {
		dao.save(produto);
	}

	@Override
	public void editar(Produtos produto) {
		dao.update(produto);

	}

	@Override
	public void excluir(long id) {
		dao.delete(id);

	}

	@Override
	@Transactional(readOnly = true)
	public Produtos buscarPorId(Long id) {
		return dao.findByID(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Produtos> buscarTodos() {
		return dao.findAll();
	}

	
}
