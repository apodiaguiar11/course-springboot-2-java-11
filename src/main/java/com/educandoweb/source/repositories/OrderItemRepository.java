package com.educandoweb.source.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.source.entities.OrderItem;

//Nessa extensão, coloco no Generics o tipo da classe Resource e o tipo do Id
//O Spring Data JPA já tem uma implementação padrão para essa interface
//Acessa os dados
//Neste caso, não uso a annotation @Repository porque estou herdando
//de JpaRepository, que já está registrado como componente do Spring.
//Por isso, é opcional colocar a annotation @Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{	
	
}
