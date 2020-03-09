package br.com.customers.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.customers.model.Ordem;

public interface OrdemRepository extends JpaRepository<Ordem, Long>{
	List<Ordem> findByCpf(String cpfUsuario);
	
}
