package com.educandoweb.source.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.source.entities.Product;
import com.educandoweb.source.services.ProductService;

//Anotação para determinar que essa classe é um recurso web
//e é implementado por um controlador rest 
@RestController
//Dando um nome para o recurso
//Na hora de acessar o localhost, irei apenas colocar esse termo value
//depois do localhost
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	

	//Método para retornar uma resposta web
	//Para indicar que esse método vai ser um método que responde
	//a requisição do tipo get do http, coloco em cima do método o seguinte anotation
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		
		List<Product> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	//Método para acessar um objeto através do Id
	//Esse Id é colocado na hora da requisição
	//http://localhost:8080/users/1
	//Essa seria uma requisoção para o objeto de Id = 1
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
