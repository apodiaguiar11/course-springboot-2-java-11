package com.educandoweb.source.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.source.entities.User;

//Nessa extensão, coloco no Generics o tipo da classe Resource e o tipo do Id
//O Spring Data JPA já tem uma implementação padrão para essa interface
//Acessa os dados
public interface UserRepository extends JpaRepository<User, Long>{	
	
}
