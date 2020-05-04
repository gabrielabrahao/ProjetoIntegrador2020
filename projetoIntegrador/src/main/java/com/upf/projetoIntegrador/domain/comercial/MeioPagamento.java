package com.upf.projetoIntegrador.domain.comercial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.upf.projetoIntegrador.domain.AbstractEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "MeioPagamento")
public class MeioPagamento extends AbstractEntity<Long> {

	@Column(nullable = false)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
}
