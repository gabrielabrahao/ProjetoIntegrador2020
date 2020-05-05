package com.upf.projetoIntegrador.domain.estoque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.upf.projetoIntegrador.domain.AbstractEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "GRUPO")
public class Grupo extends AbstractEntity<Long> {

	@Column(nullable = false, length = 20)
	@NotEmpty(message = "O nome a pessoa deve ser informado!")
	@Length(min = 2, max = 20, message = "a descrião deve ter entre {min} e {max} caracteres.")
	private String descricao;
	
	public Grupo() {
		// TODO Auto-generated constructor stub
	}
	
	public Grupo(String descricao ) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
