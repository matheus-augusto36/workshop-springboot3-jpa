package com.matteo.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matteo.demo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
