package com.upf.projetoIntegrador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upf.projetoIntegrador.domain.estoque.ProdutosFornecedores;
import com.upf.projetoIntegrador.domain.geral.ClientesFornecedores;

@Repository
public class ClientesFornecedoresDaoImpl extends AbstractDao<ClientesFornecedores, Long> implements ClientesFornecedoresDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<ProdutosFornecedores> findIdFK(Long id) {
		return entityManager
				.createQuery("from " + "ProdutosFornecedores where fornecedorid = " + id )
				.getResultList();
	}

}
