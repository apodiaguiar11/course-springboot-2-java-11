package com.educandoweb.source.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.source.entities.User;
import com.educandoweb.source.repositories.UserRepository;


//Registra-la como um componente para que possa através da annotation @Autowired funcionar a injeção de dependência.
//A partir disso, a injeção de dependência irá funcionar automaticamente usando a annotation @Autowired
//Para isso vamos usar a annotation a seguir.
//Usamos o Service para especificar também que é um serviço
@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	//Operação para salvar um dado Usuário
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//Deleção do usuário
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	
}
