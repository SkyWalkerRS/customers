package br.com.customers.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.customers.model.Ordem;

public interface OrdemRepositoryOptional extends JpaRepository<Ordem, Long>{
	Optional<Ordem> findByCpf(String cpf);
	
}
