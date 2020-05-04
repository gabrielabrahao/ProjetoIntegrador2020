package com.upf.projetoIntegrador.domain.comercial;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.upf.projetoIntegrador.domain.AbstractEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "Meio_pagamento_Pedido")
public class MeioPagamentoPedido extends AbstractEntity<Long> {

	
	@ManyToOne
    @JoinColumn
    private Pedido pedidoId;
	
	@ManyToOne
    @JoinColumn
    private MeioPagamento MeioPagamentoId;
	
	@Column(nullable = false)
	private float valor;
	
	@Column(nullable = false)
	private int forma;
	
	@Column(name = "data",nullable = false, columnDefinition = "DATE")
	private LocalDate data;

	public Pedido getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Pedido pedidoId) {
		this.pedidoId = pedidoId;
	}

	public MeioPagamento getMeioPagamentoId() {
		return MeioPagamentoId;
	}

	public void setMeioPagamentoId(MeioPagamento meioPagamentoId) {
		MeioPagamentoId = meioPagamentoId;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getForma() {
		return forma;
	}

	public void setForma(int forma) {
		this.forma = forma;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
}
