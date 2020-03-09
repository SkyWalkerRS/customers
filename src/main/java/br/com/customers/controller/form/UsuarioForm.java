package br.com.customers.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.customers.model.Endereco;
import br.com.customers.model.Usuario;
import br.com.customers.repository.UsuarioRepository;

public class UsuarioForm {
	
	@NotNull @NotEmpty @Length(min=3)
	private String nome;
	
	@NotNull @NotEmpty @Length(min=11)
	private String cpf;
	private String cidadeEndereco;
	
	
	public String getNome() {
		return nome;
	}
	
//	public Endereco getCidadeEndereco() {
//		return cidadeEndereco;
//	}

	

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Usuario converter(UsuarioRepository usuarioRepository) {
		Optional<Usuario> usuario = usuarioRepository.findByCpf(cpf);
		return new Usuario();
	}

	
	
}
