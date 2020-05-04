package com.upf.projetoIntegrador.domain.comercial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.upf.projetoIntegrador.domain.AbstractEntity;
import com.upf.projetoIntegrador.domain.estoque.Produtos;

@SuppressWarnings("serial")
@Entity
@Table(name = "Pedido_Itens")
public class PedidoItens extends AbstractEntity<Long> {

	@ManyToOne
    @JoinColumn
    private Pedido pedidoId;
	
	@ManyToOne
    @JoinColumn
    private Produtos produtoId;

	@Column(nullable = false)
	private float quantidade;
	
	@Column(nullable = false)
	private float preco;

	public Pedido getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Pedido pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Produtos getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Produtos produtoId) {
		this.produtoId = produtoId;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
	
}
