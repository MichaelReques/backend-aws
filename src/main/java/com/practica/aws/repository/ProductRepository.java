package com.practica.aws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica.aws.model.Product;

@Repository 
public interface ProductRepository extends JpaRepository<Product, Long>{


}
