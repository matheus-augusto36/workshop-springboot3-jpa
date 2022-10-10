package com.matteo.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matteo.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}

//UserRepository não precisa de registro para injeção de dep. porque ela herda de uma interface que já está registrada.
//Não é necessário criar uma implementação desta interface, pois isso é feito automaticamente pelo SpringDataJPA