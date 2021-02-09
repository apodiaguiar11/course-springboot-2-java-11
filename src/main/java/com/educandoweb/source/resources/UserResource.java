package com.educandoweb.source.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.source.entities.User;
import com.educandoweb.source.services.UserService;

//Anotação para determinar que essa classe é um recurso web
//e é implementado por um controlador rest 
@RestController
//Dando um nome para o recurso
//Na hora de acessar o localhost, irei apenas colocar esse termo value
//depois do localhost
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	

	//Método para retornar uma resposta web
	//Para indicar que esse método vai ser um método que responde
	//a requisição do tipo get do http, coloco em cima do método o seguinte anotation
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	//Método para acessar um objeto através do Id
	//Esse Id é colocado na hora da requisição
	//http://localhost:8080/users/1
	//Essa seria uma requisoção para o objeto de Id = 1
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//Inserir um novo usuário no Banco de Dados
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		//Gerando um endereço URI
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
}
