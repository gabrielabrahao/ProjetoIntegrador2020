package com.upf.projetoIntegrador.domain.geral;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.upf.projetoIntegrador.domain.Pessoa;

@SuppressWarnings("serial")
@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario extends Pessoa<Long> {
	
	@Column(nullable = false, unique = true)
	private String login;
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false, length = 14)
	@NotEmpty(message = "É obrigatório informar um CPF.")
	@Length(min = 14, max = 14, message = "É necessário informar todos os 14 caracteres para o CPF.")
	@CPF
	private String cpf;
	
	@Column(nullable = false, length = 20)
	@NotEmpty(message = "É obrigatório informar um número de documento RG.")
	@Length(max = 20, message = "O RG deve conter no máximo {max} caracteres.")
	private String rg;

	@Column(name = "data_entrada",nullable = false, columnDefinition = "DATE")
	private LocalDate dataEntrada;
	
	@Column(name = "data_saida", columnDefinition = "DATE")
	private LocalDate dataSaida;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	
	

}
