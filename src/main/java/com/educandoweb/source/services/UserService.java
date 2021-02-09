package com.educandoweb.source.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.source.entities.User;
import com.educandoweb.source.repositories.UserRepository;
import com.educandoweb.source.services.exceptions.DatabaseException;
import com.educandoweb.source.services.exceptions.ResourceNotFoundException;


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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//Operação para salvar um dado Usuário
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//Deleção do usuário
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	//Atualizar um usuário
	//Atualizar só os atributos: name, email, phone.
	public User update(Long id, User obj) {
		//O comando getOne prepara o objeto monitorado para poder manusear
		//para só depois efetuar uma operação com o Banco de dados.
		//Mais eficiente do que usar o findById
		try {
			User entity = repository.getOne(id);
			updateData(entity,obj);
			return repository.save(entity);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());		
	}
	
	
	
}
