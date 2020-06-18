package com.upf.projetoIntegrador.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.upf.projetoIntegrador.domain.geral.Endereco;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class Pessoa <ID extends Serializable> implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private ID id;
	
	@Column(nullable = false, length = 60)
	@NotEmpty(message = "O nome a pessoa deve ser informado!")
	@Length(min = 2, max = 60, message = "O nome deve ter entre 2 e 60 caracteres.")
	private String nome;

	// Com esse atributo sempre delete/incluir o end ao adicionar/excluir o
	// funcionario
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;

	@Column(length = 80)
	@Email(message = "O formato do e-mail é inválido!")
	@Length(max = 80, message = "O e-mail deve conter no máximo {max} caracteres.")
	private String email;

	@Column(length = 20)
	@Length(max = 20, message = "O telefone deve conter no máximo {max} caracteres.")
	private String telefone;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_Nascimento", columnDefinition = "DATE")
	//@NotNull(message = "É necessário informar uma data de nascimento.")
	//@Past(message = "Informe uma data no passado.")
	private LocalDate dataNascimento;
	
	

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
}
