package com.upf.projetoIntegrador.domain.estoque;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.upf.projetoIntegrador.domain.AbstractEntity;
import com.upf.projetoIntegrador.domain.comercial.PedidoItens;
import com.upf.projetoIntegrador.domain.geral.ClientesFornecedores;

@SuppressWarnings("serial")
@Entity
@Table(name = "PRODUTOS")
public class Produtos extends AbstractEntity<Long> {
	
	@Column(nullable = false, length = 60)
	@Length(min = 2, max = 60, message = "A Descricao deve ter entre {min} e {max} caracteres.")
	private String descricao;
	
	@Column(nullable = false, length = 3)
	@Length(min = 2, max = 3, message = "A Un deve ter entre {min} e {max} caracteres.")
	private String unidadeEstoque;
	
	
	private Float estoqueAtual;
	
	private Float preco;
	
	boolean Ativo;
	
	@OneToMany(mappedBy = "produtoid", cascade = CascadeType.ALL)
	private List<ProdutosFornecedores> produtosFornecedores;
	
	@OneToMany(mappedBy = "produtoId", cascade = CascadeType.ALL)
	private List<PedidoItens> possuiPedido; 

	  @ManyToOne
	  private Grupo grupo;
	
	
	
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<PedidoItens> getPossuiPedido() {
		return possuiPedido;
	}

	public void setPossuiPedido(List<PedidoItens> possuiPedido) {
		this.possuiPedido = possuiPedido;
	}

	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "Produto_Fornecedores", joinColumns = @JoinColumn(name =
	 * "produtoid"), inverseJoinColumns = @JoinColumn(name = "fornecedorid" ))
	 * private List<ProdutosFornecedores> prodFornecedores;
	 */
	
	
	
	
	public List<ProdutosFornecedores> getProdutosFornecedores() {
		return produtosFornecedores;
	}

	public void setProdutosFornecedores(List<ProdutosFornecedores> produtosFornecedores) {
		this.produtosFornecedores = produtosFornecedores;
	}

	
	

	


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidadeEstoque() {
		return unidadeEstoque;
	}

	public void setUnidadeEstoque(String unidadeEstoque) {
		this.unidadeEstoque = unidadeEstoque;
	}

	public Float getEstoqueAtual() {
		return estoqueAtual;
	}

	public void setEstoqueAtual(Float estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public boolean isAtivo() {
		return Ativo;
	}

	public void setAtivo(boolean ativo) {
		Ativo = ativo;
	}
	
	

}
