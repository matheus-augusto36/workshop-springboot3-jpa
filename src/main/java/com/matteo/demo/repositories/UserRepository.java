package com.matteo.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matteo.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	//Não é necessário criar uma implementação desta interface, pois isso é feito automaticamente pelo SpringDataJPA
}
