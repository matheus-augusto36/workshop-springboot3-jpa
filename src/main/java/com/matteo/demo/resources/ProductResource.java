package com.matteo.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matteo.demo.entities.Product;
import com.matteo.demo.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired 
	private ProductService service;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}

/*
 *ResponseEntity representa uma resposta HTTP, incluindo cabeçalhos, corpo e status. Enquanto @ResponseBody coloca o valor de retorno no corpo da resposta, ResponseEntity também nos permite adicionar cabeçalhos e código de status. 
*/