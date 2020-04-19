package com.training.dailymartapi.service;

import java.util.List;

import com.training.dailymartapi.model.Product;

public interface ProductService {
	
	String saveProduct(Product product);
	List<Product> getAllProducts();
	Product getProductById(long id);

}
