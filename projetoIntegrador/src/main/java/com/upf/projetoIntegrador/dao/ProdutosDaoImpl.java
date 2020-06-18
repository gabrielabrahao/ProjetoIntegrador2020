package com.upf.projetoIntegrador.dao;

import org.springframework.stereotype.Repository;

import com.upf.projetoIntegrador.domain.estoque.Produtos;

@Repository
public class ProdutosDaoImpl  extends AbstractDao<Produtos, Long> implements ProdutosDao {

}
