package com.training.dailymartapi.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.training.dailymartapi.exception.RecordExistException;
import com.training.dailymartapi.exception.RecordNotCreatedException;
import com.training.dailymartapi.exception.RecordNotDeletedException;
import com.training.dailymartapi.exception.RecordNotFoundException;
import com.training.dailymartapi.exception.RecordNotUpdatedException;
import com.training.dailymartapi.model.Category;
import com.training.dailymartapi.repository.CategoryRepository;
import com.training.dailymartapi.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public String saveCategory(Category category) throws RecordExistException, RecordNotCreatedException {

		String message = "";

		try {

			if (this.categoryRepo.findByName(category.getName()) != null) {

				message = "Category " + category.getName() + " already exists. Provide a unique name";
				throw new RecordExistException(message);
			}
			this.categoryRepo.save(category);
			message = "Succesfully saved the category " + category.getName();
		} catch (DataIntegrityViolationException e) {
			throw new RecordNotCreatedException("Something went wrong in saving category from service", e);
		} catch (DataAccessException e) {
			throw new RecordNotCreatedException("Something went wrong in accessing db from service", e);
		}
		return message;
	}

	@Override
	public List<Category> getAllCategories() throws RecordNotFoundException {

		try {

			return this.categoryRepo.findAll();

		} catch (DataAccessException e) {
			throw new RecordNotFoundException("Something went wrong in fetching category list", e);
		}

	}

	@Override
	public Category getCategoryById(long id) throws RecordNotFoundException {

		try {
			return this.categoryRepo.getOne(id);
		} catch (NoSuchElementException e) {
			throw new RecordNotFoundException("No category found.", e);
		} catch (DataAccessException e) {
			throw new RecordNotFoundException("Something went wrong in accessing category", e);
		}
	}

	@Override
	public String deleteCategory(long id) throws RecordNotDeletedException {

		String message = "";
		try {
			this.categoryRepo.deleteById(id);

			message = "Successfully deleted category";

		} catch (EmptyResultDataAccessException e) {
			message = "Sorry!! Trying to delete invalid category - " + id + " from service";
			throw new RecordNotDeletedException();
		} catch (DataAccessException e) {
			message = "Sorry..Something went wrong in deleting category - " + id + " from service";
			throw new RecordNotDeletedException();
		}

		return message;
	}

	@Override
	public String updateCategory(Category updatedCategory) throws RecordNotUpdatedException, RecordExistException, RecordNotCreatedException {

		String message = "";

		try {

			Category existingCategory = this.getCategoryById(updatedCategory.getCid());
			Category revisedCategory = updatedCategory;
			revisedCategory.setCid(existingCategory.getCid());

			this.saveCategory(revisedCategory);

			message = "Successfully updated category - " + revisedCategory.getName();

		} catch (RecordNotFoundException e) {
			message = "Updation failed. Category - " + updatedCategory.getName();
			throw new RecordNotUpdatedException(message, e);
		}

		return null;
	}

}
