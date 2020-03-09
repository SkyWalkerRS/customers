package br.com.customers.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.customers.model.Ordem;


public class OrdemDto {
	
	private Long id;
	private String cpf; //refactor dps, pegar o cpf do user
	private Long valorTotal;
	
	public OrdemDto(Ordem order) {
		this.id = order.getId();
		this.valorTotal = order.getValorTotal();
		this.cpf = order.getCpf();
		
	}
	
	
	public Long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public Long getValorTotal() {
		return valorTotal;
	}

	public static List<OrdemDto> converter(List<Ordem> order) {
		return order.stream().map(OrdemDto::new).collect(Collectors.toList());
	}
	
	
	

}
