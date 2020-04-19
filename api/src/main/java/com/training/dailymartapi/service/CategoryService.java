package com.training.dailymartapi.service;

import java.util.List;

import com.training.dailymartapi.model.Category;

public interface CategoryService {

	String saveCategory(Category category);
	List<Category> getAllCategories();
	Category getCategoryById(long id);
}
