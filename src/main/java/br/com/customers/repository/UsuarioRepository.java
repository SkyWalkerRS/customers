package br.com.customers.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.customers.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByCpf(String cpf);
	
}
