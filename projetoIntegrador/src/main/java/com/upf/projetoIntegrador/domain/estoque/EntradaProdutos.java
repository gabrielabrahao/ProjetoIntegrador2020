package com.upf.projetoIntegrador.domain.estoque;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.upf.projetoIntegrador.domain.AbstractEntity;
import com.upf.projetoIntegrador.domain.geral.ClientesFornecedores;

@SuppressWarnings("serial")
@Entity
@Table(name = "ENTRADAS_PRODUTOS")
public class EntradaProdutos extends AbstractEntity<Long> {
	
	@Column(nullable = false)
	private String numeroNota;
	
	@Column(name = "data_entrada",nullable = false, columnDefinition = "DATE")
	private LocalDate dataEntrada;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fornecedor_id")
	private ClientesFornecedores fornecedor;
	
	@OneToMany(mappedBy = "entrada_Id", cascade = CascadeType.ALL) 
	private List<EntradaItens> itens;

	public String getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(String numeroNota) {
		this.numeroNota = numeroNota;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public ClientesFornecedores getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(ClientesFornecedores fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<EntradaItens> getItens() {
		return itens;
	}

	public void setItens(List<EntradaItens> itens) {
		this.itens = itens;
	} 
	
	
	

}
