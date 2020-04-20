package com.training.dailymartapi.service;

import java.util.List;

import com.training.dailymartapi.exception.RecordExistException;
import com.training.dailymartapi.exception.RecordNotCreatedException;
import com.training.dailymartapi.exception.RecordNotDeletedException;
import com.training.dailymartapi.exception.RecordNotFoundException;
import com.training.dailymartapi.exception.RecordNotUpdatedException;
import com.training.dailymartapi.model.Category;

public interface CategoryService {

	String saveCategory(Category category) throws RecordExistException, RecordNotCreatedException;
	List<Category> getAllCategories() throws RecordNotFoundException;
	Category getCategoryById(long id) throws RecordNotFoundException;
	String deleteCategory(long id) throws RecordNotDeletedException;
	String updateCategory(Category updatedCategory) throws RecordNotUpdatedException, RecordExistException, RecordNotCreatedException;
	
}
