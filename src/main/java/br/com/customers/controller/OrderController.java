package br.com.customers.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.customers.dto.OrdemDto;
import br.com.customers.model.Ordem;
import br.com.customers.repository.OrdemRepository;

@RestController
@RequestMapping("/ordens")

public class OrderController {
	@Autowired
	private OrdemRepository ordemRepository;
	
	
	
	@GetMapping
	public List<OrdemDto> lista(String cpfUsuario){
		if(cpfUsuario==null) {
			List<Ordem> order = ordemRepository.findAll();
			return OrdemDto.converter(order);
		}else {
			List<Ordem> order = ordemRepository.findByCpf(cpfUsuario);
			return OrdemDto.converter(order);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdemDto> detalhar(@PathVariable Long id) {
		Optional<Ordem> ordem = ordemRepository.findById(id);
		if (ordem.isPresent()) {
			return ResponseEntity.ok(new OrdemDto(ordem.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
//	public Boolean pedido(String cpf,double pedido) {
//		User user = conta.getPoints();
//		if (conta.getPoints > pedido) {
//			return true;
//		}else:
//			return false;
//	}

}
