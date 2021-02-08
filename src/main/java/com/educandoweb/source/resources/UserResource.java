package com.educandoweb.source.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.source.entities.User;

//Anotação para determinar que essa classe é um recurso web
//e é implementado por um controlador rest 
@RestController
//Dando um nome para o recurso
@RequestMapping(value = "/users")
public class UserResource {

	//Método para retornar uma resposta web
	//Para indicar que esse método vai ser um método que responde
	//a requisição do tipo get do http, coloco em cima do método o seguinte anotation
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "99999999", "12345");
		return ResponseEntity.ok().body(u);
	}
	
	
}
