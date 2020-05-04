package com.upf.projetoIntegrador.domain.comercial;

import java.util.List;

import javax.persistence.*;


import com.upf.projetoIntegrador.domain.AbstractEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "Pedido_Status")
public class StatusPedido extends AbstractEntity<Long> {

	
	
	
	@Column(nullable = false)
	private String descricao;
	
	@OneToMany( cascade = CascadeType.ALL)
	private List<Pedido> pedidosNoStatus;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Pedido> getPedidosNoStatus() {
		return pedidosNoStatus;
	}

	public void setPedidosNoStatus(List<Pedido> pedidosNoStatus) {
		this.pedidosNoStatus = pedidosNoStatus;
	}
	
	
	
}
