package br.com.customers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cep;
	private String cidade;
	private String bairro;
	private String logradouro;
	
	public String getCep() {
		return cep;
	}
	public String getCidade() {
		return cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	
}
