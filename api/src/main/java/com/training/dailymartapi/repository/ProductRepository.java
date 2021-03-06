package com.training.dailymartapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.dailymartapi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
