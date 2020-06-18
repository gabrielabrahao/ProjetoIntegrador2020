package com.upf.projetoIntegrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upf.projetoIntegrador.dao.ClientesFornecedoresDao;
import com.upf.projetoIntegrador.dao.ProdutosDao;
import com.upf.projetoIntegrador.dao.ProdutosFornecedoresDao;
import com.upf.projetoIntegrador.domain.estoque.ProdutosFornecedores;

@Service
@Transactional(readOnly = false) // Essa informação é implicita, informado apenas para conhecimento
public class ProdutosFornecedoresServiceImpl implements ProdutosFornecedoresService {

	@Autowired
	ProdutosFornecedoresDao dao;
	@Autowired
	ProdutoService produto;
	@Autowired
	ClientesFornecedoresService clientesFornecedores;

	@Override
	public void salvar( Long idProduto, Long idFornecedor) {
		
		ProdutosFornecedores fornecedores = new ProdutosFornecedores();
		
	    fornecedores.setFornecedorid(clientesFornecedores.buscarPorId(idFornecedor));
	    fornecedores.setProdutoid(produto.buscarPorId(idProduto));
		dao.save(fornecedores);
	}

	@Override
	public void editar(ProdutosFornecedores fornecedores) {
		dao.update(fornecedores);

	}

	@Override
	public void excluir(long id) {
		dao.delete(id);

	}

	@Override
	@Transactional(readOnly = true)
	public ProdutosFornecedores buscarPorId(Long id) {
		return dao.findByID(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProdutosFornecedores> buscarTodos() {
		return dao.findAll();
	}
}
