package com.educandoweb.source.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.source.entities.Product;
import com.educandoweb.source.repositories.ProductRepository;


//Registra-la como um componente para que possa através da annotation @Autowired funcionar a injeção de dependência.
//A partir disso, a injeção de dependência irá funcionar automaticamente usando a annotation @Autowired
//Para isso vamos usar a annotation a seguir.
//Usamos o Service para especificar também que é um serviço
@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
	
}
