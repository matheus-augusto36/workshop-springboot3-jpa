package com.matteo.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matteo.demo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
