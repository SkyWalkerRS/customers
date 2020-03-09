package br.com.customers.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.customers.model.Usuario;
import br.com.customers.repository.UsuarioRepository;

public class AtualizacaoUsuarioForm {
	
	@NotEmpty @NotNull @Length(min=3)
	private String nome;
	
	@NotEmpty @NotNull @Length(min=11)
	private String cpf;
	//endereco
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getOne(id);
		
		usuario.setNome(this.nome);
		usuario.setCpf(this.cpf);
		
		return usuario;

	}

	
}
