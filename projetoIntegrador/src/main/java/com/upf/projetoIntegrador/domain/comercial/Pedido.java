package com.upf.projetoIntegrador.domain.comercial;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;


import com.upf.projetoIntegrador.domain.AbstractEntity;
import com.upf.projetoIntegrador.domain.estoque.Produtos;
import com.upf.projetoIntegrador.domain.geral.ClientesFornecedores;

@SuppressWarnings("serial")
@Entity
@Table(name = "PEDIDOS")
public class Pedido extends AbstractEntity<Long> {

	@Column(name = "data",nullable = false, columnDefinition = "DATE")
	private LocalDate data;
	
	public List<MeioPagamentoPedido> getListPagamento() {
		return listPagamento;
	}

	public void setListPagamento(List<MeioPagamentoPedido> listPagamento) {
		this.listPagamento = listPagamento;
	}

	private float desconto;
	
	private float valorFrete;
	
	@Column(name = "data_entrega",nullable = false, columnDefinition = "DATE")
	private LocalDate dataEntrega;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fornecedor_id")
	private ClientesFornecedores fornecedor;
	
	@OneToMany(mappedBy = "pedidoId", cascade = CascadeType.ALL)
	private List<PedidoItens> itens;
	
	@OneToMany(mappedBy = "pedidoId", cascade = CascadeType.ALL)
	private List<MeioPagamentoPedido> listPagamento;
	
    @ManyToOne
    @JoinColumn(name = "Status_id_fk")
    private StatusPedido status;
    
	
	
    public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public float getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(float valorFrete) {
		this.valorFrete = valorFrete;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public ClientesFornecedores getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(ClientesFornecedores fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<PedidoItens> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItens> itens) {
		this.itens = itens;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	
    
    
	
	
}
