package com.training.dailymartapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.dailymartapi.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

}
