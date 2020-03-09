package br.com.customers.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.customers.repository.UsuarioRepository;
import br.com.customers.controller.form.UsuarioForm;
import br.com.customers.dto.UsuarioDto;
import br.com.customers.controller.form.AtualizacaoUsuarioForm;
import br.com.customers.model.Usuario;
import br.com.customers.repository.UsuarioRepositoryCpf;;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	private UsuarioRepositoryCpf usuarioRepositoryCpf;
	
	
	@GetMapping
	public List<UsuarioDto> lista(String cpfUsuario){
		if(cpfUsuario==null) {
			List<Usuario> usuario = usuarioRepository.findAll();
			return UsuarioDto.converter(usuario);
		}else {
			List<Usuario> usuario = usuarioRepositoryCpf.findByCpf(cpfUsuario);
			return UsuarioDto.converter(usuario);
		}
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form,UriComponentsBuilder uriBuilder){
		Usuario usuario = form.converter(usuarioRepository);
		usuarioRepository.save(usuario);
		
		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> detalhar(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return ResponseEntity.ok(new UsuarioDto(usuario.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/cpf/{cpf}")
	
	public ResponseEntity<UsuarioDto> detalhar2(@PathVariable String cpf ) {
		Optional<Usuario> usuario = usuarioRepository.findByCpf(cpf);
		if (usuario.isPresent()) {
			return ResponseEntity.ok(new UsuarioDto(usuario.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
	@PutMapping("{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> atualizar (@PathVariable Long id, @RequestBody @Valid AtualizacaoUsuarioForm form){
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if(optional.isPresent()) {
			Usuario usuario = form.atualizar(id, usuarioRepository);
			return ResponseEntity.ok(new UsuarioDto(usuario));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if (optional.isPresent()) {
			usuarioRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

	
	
	
	
}
