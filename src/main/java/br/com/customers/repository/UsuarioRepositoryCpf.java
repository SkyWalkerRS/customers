package br.com.customers.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.customers.model.Usuario;

public interface UsuarioRepositoryCpf extends JpaRepository<Usuario, Long> {
	List<Usuario> findByCpf(String cpf);
}
