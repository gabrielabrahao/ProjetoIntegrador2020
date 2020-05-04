package com.upf.projetoIntegrador.domain.estoque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.upf.projetoIntegrador.domain.AbstractEntity;
import com.upf.projetoIntegrador.domain.comercial.Pedido;

@SuppressWarnings("serial")
@Entity
@Table(name = "Entrada_Itens")
public class EntradaItens extends AbstractEntity<Long> {
	
	@ManyToOne
    @JoinColumn
    private EntradaProdutos entrada_Id;
	
	@ManyToOne
    @JoinColumn
    private Produtos produto_Id;

	@Column(nullable = false)
	private float quantidade;
	@Column(nullable = false)
	private float custo;
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	public float getCusto() {
		return custo;
	}
	public void setCusto(float custo) {
		this.custo = custo;
	}

	public EntradaProdutos getEntrada_Id() {
		return entrada_Id;
	}
	public void setEntrada_Id(EntradaProdutos entrada_Id) {
		this.entrada_Id = entrada_Id;
	}
	public Produtos getProduto_Id() {
		return produto_Id;
	}
	public void setProduto_Id(Produtos produto_Id) {
		this.produto_Id = produto_Id;
	}
	
}
