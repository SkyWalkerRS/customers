package br.com.customers.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.customers.model.Usuario;


public class UsuarioDto {
	
	private Long id;
	private String nome;
	private String cpf;
	private String cidadeEndereco;
	
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.setCidadeEndereco(usuario.getEndereco().getCidade());
	}
	

	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public String getCpf() {
		return cpf;
	}
	//ende


	public static List<UsuarioDto> converter(List<Usuario> usuario) {
		return usuario.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}


	public String getCidadeEndereco() {
		return cidadeEndereco;
	}


	public void setCidadeEndereco(String cidadeEndereco) {
		this.cidadeEndereco = cidadeEndereco;
	}
	
	
	
	
	
	
}
