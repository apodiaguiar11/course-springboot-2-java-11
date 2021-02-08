package com.educandoweb.source.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.source.entities.Order;
import com.educandoweb.source.entities.User;
import com.educandoweb.source.repositories.OrderRepository;
import com.educandoweb.source.repositories.UserRepository;

//Para falar para o Spring que essa é uma classe específica de configuração,
//usamos a anotation a seguir.
@Configuration
//Para falar que essa classe será uma configuração específica para o perfil de teste,
//preciso colocar a annotation a seguir.
//O nome "test" deve ser o mesmo colocado no código do arquivo application.properties, ou seja,
//spring.profiles.active=test (Seria o mesmo nome colocado nessa linha de código)
@Profile("test")
public class TestConfig implements CommandLineRunner{

	//A annotation a seguir resolve automaticamente essa dependência e 
	//associa uma instância de userRepository aqui dentro
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	//Método para rodar o código a seguir
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		//Salvar no Banco de dados
		//Objeto userRepository acessa os dados
		//Passo uma lista
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		
		
	}
	
	
	
	
}
