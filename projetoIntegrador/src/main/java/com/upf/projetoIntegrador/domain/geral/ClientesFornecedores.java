package com.upf.projetoIntegrador.domain.geral;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.upf.projetoIntegrador.domain.Pessoa;
import com.upf.projetoIntegrador.domain.estoque.Produtos;

@SuppressWarnings("serial")
@Entity
@Table(name = "Clientes_Forncedores")
public class ClientesFornecedores extends Pessoa<Long> {
	
	@Column(nullable = false, length = 14)
	private String cpfCnpj ;

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	
	
	@ManyToMany(mappedBy = "prodFornecedores")
	List<Produtos> prodFornecedores;

	public List<Produtos> getProdFornecedores() {
		return prodFornecedores;
	}

	public void setProdFornecedores(List<Produtos> prodFornecedores) {
		this.prodFornecedores = prodFornecedores;
	}
	
}
