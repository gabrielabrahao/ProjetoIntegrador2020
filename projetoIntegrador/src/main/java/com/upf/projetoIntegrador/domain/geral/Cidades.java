package com.upf.projetoIntegrador.domain.geral;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.upf.projetoIntegrador.domain.AbstractEntity;
import com.upf.projetoIntegrador.domain.UF;



@SuppressWarnings("serial")
@Entity
@Table(name = "CIDADES")
public class Cidades extends AbstractEntity<Long> {

	@Column(nullable = false, length = 60)
	@NotEmpty(message = "É necessário informar um nome para a Cidade!")
	@Length(min = 2, max = 30, message = "O nome da cidade deve ter entre {min} e {max} caracteres.")
	private String nome;
	
	/*
	 * @Column(nullable = false, length = 2)
	 * 
	 * @Enumerated(EnumType.STRING)//Dessa informa , diz que tipo de dados salva no
	 * BD private UF uf;
	 */
	
	@Column(nullable = false, length = 2)
	private String  uf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	
	
	
}
