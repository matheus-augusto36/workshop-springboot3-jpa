package com.matteo.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matteo.demo.entities.User;
import com.matteo.demo.services.UserService;

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
	
	
}

//@GetMapping indica que o argumento será passado na url e que este método responde a requisições "GET" do protocolo HTTP
//@PathVariable permite que o método aceite argumento via url
/*
 * ok() -> Retorna a resposta (Se a operação foi concluída com sucesso ou não)
 * body() -> Retorna o "corpo" da resposta.
 * 
 */
//@RestController mostra que a classe é um controlador
//@RequestMapping(value = "/users") indica o nome que irei digitar na url ao fazer a requisição. Ex: "http://localhost:8080/users "
