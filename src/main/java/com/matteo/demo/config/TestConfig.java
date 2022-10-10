package com.matteo.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.matteo.demo.entities.User;
import com.matteo.demo.repositories.UserRepository;

@Configuration //Indica que é uma classe de configuração
@Profile("test") //Indica que a classe só será usada no perfil de teste
public class TestConfig implements CommandLineRunner {

	@Autowired //Desacoplamento implícito (Boa prática!)
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		//Este método é executado quando a aplicação é iniciada.
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	
}
