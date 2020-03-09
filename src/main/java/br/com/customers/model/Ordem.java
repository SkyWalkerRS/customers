package br.com.customers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordem {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column (name = "valorTotal")
	private Long valorTotal;
	private String cpf;
	
	public Ordem() {
		
	}
	
	public Ordem(Long valorTotal, String cpf) {
		this.valorTotal = valorTotal;
		this.cpf = cpf;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setValorTotal(Long valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}
	
	public Long getValorTotal() {
		return valorTotal;
	}

	public String getCpf() {
		return cpf;
	}

	
	
}
