package com.matteo.demo.resources;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matteo.demo.entities.User;
import com.matteo.demo.services.UserService;

import jakarta.persistence.FetchType;

@RestController 
@RequestMapping(value = "/users") 
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping 
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<User> findById(@PathVariable("id") Long id) { 
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}

//@GetMapping indica que o argumento será passado na url e que este método responde a requisições "GET" do protocolo HTTP
//@PathVariable permite que o método aceite argumento via url
/*
 * ok() -> Retorna a resposta (Se a operação foi concluída com sucesso ou não)
 * body() -> Retorna o "corpo" da resposta.
 * ResponseEntity<Void> -> A resposta do método não retornará nada, por isso o tipo que ResponseEntity precisa ser void.
 * build() -> Build the response entity with no body. 
 */
//@RestController mostra que a classe é um controlador
//@RequestMapping(value = "/users") indica o nome que irei digitar na url ao fazer a requisição. Ex: "http://localhost:8080/users "
