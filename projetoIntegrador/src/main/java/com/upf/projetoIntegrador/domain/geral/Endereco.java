package com.upf.projetoIntegrador.domain.geral;


import com.upf.projetoIntegrador.domain.AbstractEntity;
import com.upf.projetoIntegrador.domain.UF;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "ENDERECOS")
public class Endereco extends AbstractEntity<Long> {
	@Column(nullable = false)
	private String logradouro;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private String  cidade;
	
	
	@Column(nullable = true, length = 2)
	@Enumerated(EnumType.STRING)//Dessa informa , diz que tipo de dados salva no BD
	private UF uf; 
	
	@Column(nullable = true, length = 9 )
	private String cep;
	
	@Column(nullable = false, length = 5)
	private Integer numero;
	
	private String complemento;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}	
}