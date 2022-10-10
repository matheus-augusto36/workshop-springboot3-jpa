package com.matteo.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matteo.demo.entities.User;

@RestController //Mostra que a classe é um controlador
@RequestMapping(value = "/users") // Indica o nome que irei digitar na url ao fazer a requisição. Ex: "http://localhost:8080/users"
public class UserResource {

	@GetMapping //indica que este método responde a requisições "GET" dp protocolo HTTP
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "maria", "maria@gmail", "9999999", "1234");
		return ResponseEntity.ok().body(u);
		/*
		 * ok() -> Retorna a resposta (Se a operação foi concluída com sucesso ou não)
		 * body() -> Retorna o "corpo" da resposta.
		 */
	}
	
}
