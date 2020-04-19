package com.training.dailymartapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.dailymartapi.model.ProductReview;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {

}
