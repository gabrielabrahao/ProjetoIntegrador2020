package com.upf.projetoIntegrador.domain.estoque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.upf.projetoIntegrador.domain.AbstractEntity;

import com.upf.projetoIntegrador.domain.geral.ClientesFornecedores;

@SuppressWarnings("serial")
@Entity
@Table(name = "Produto_Fornecedores")
public class ProdutosFornecedores extends AbstractEntity<Long> {
	
	@ManyToOne
    @JoinColumn
    private Produtos produtoid;
	
	@ManyToOne
    @JoinColumn
    @NotNull
    private ClientesFornecedores fornecedorid;

	public Produtos getProdutoid() {
		return produtoid;
	}

	public void setProdutoid(Produtos produtoid) {
		this.produtoid = produtoid;
	}

	public ClientesFornecedores getFornecedorid() {
		return fornecedorid;
	}

	public void setFornecedorid(ClientesFornecedores fornecedorid) {
		this.fornecedorid = fornecedorid;
	}
	
	

	
	
}
