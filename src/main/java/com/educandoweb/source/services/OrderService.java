package com.educandoweb.source.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.source.entities.Order;
import com.educandoweb.source.repositories.OrderRepository;


//Registra-la como um componente para que possa através da annotation @Autowired funcionar a injeção de dependência.
//A partir disso, a injeção de dependência irá funcionar automaticamente usando a annotation @Autowired
//Para isso vamos usar a annotation a seguir.
//Usamos o Service para especificar também que é um serviço
@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
	
}
