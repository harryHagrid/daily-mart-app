package com.training.dailymartapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.dailymartapi.exception.RecordExistException;
import com.training.dailymartapi.exception.RecordNotCreatedException;
import com.training.dailymartapi.exception.RecordNotDeletedException;
import com.training.dailymartapi.exception.RecordNotFoundException;
import com.training.dailymartapi.exception.RecordNotUpdatedException;
import com.training.dailymartapi.model.Category;
import com.training.dailymartapi.restApiConfig.model.ApiSuccessResponse;
import com.training.dailymartapi.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody Category category)
			throws RecordExistException, RecordNotCreatedException {

		String message = "";

		ApiSuccessResponse response = new ApiSuccessResponse();

		message = this.categoryService.saveCategory(category);

		response.setMessage("Successfully saved - " + category.getName());
		response.setHttpStatus(String.valueOf(HttpStatus.CREATED));
		response.setHttpStatusCode(201);
		response.setBody(message);
		response.setError(false);
		response.setSuccess(true);

		return ResponseEntity.status(HttpStatus.CREATED).header("status", String.valueOf(HttpStatus.CREATED))
				.body(response);

	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllCategories() throws RecordNotFoundException {

		List<Category> categories = new ArrayList<Category>();

		ApiSuccessResponse response = new ApiSuccessResponse();

		categories = this.categoryService.getAllCategories();

		response.setMessage("Total categories found - " + categories.size());
		response.setHttpStatus(String.valueOf(HttpStatus.FOUND));
		response.setHttpStatusCode(302);
		response.setBody(categories);
		response.setError(false);
		response.setSuccess(true);

		return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.FOUND)).body(response);

	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getCategoryById(@PathVariable long id) throws RecordNotFoundException {

		ApiSuccessResponse response = new ApiSuccessResponse();

		Category category = this.categoryService.getCategoryById(id);

		response.setMessage("Successfully fetched category id - " + id);
		response.setHttpStatus(String.valueOf(HttpStatus.FOUND));
		response.setHttpStatusCode(302);
		response.setBody(category);
		response.setError(false);
		response.setSuccess(true);

		return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.FOUND)).body(response);

	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteCategoryById(@PathVariable long id) throws RecordNotDeletedException {

		ApiSuccessResponse response = new ApiSuccessResponse();

		String message = this.categoryService.deleteCategory(id);

		response.setMessage("Successfully deleted category.");
		response.setHttpStatus(String.valueOf(HttpStatus.ACCEPTED));
		response.setHttpStatusCode(202);
		response.setBody(message);
		response.setError(false);
		response.setSuccess(true);

		return ResponseEntity.status(HttpStatus.ACCEPTED).header("status", String.valueOf(HttpStatus.ACCEPTED))
				.body(response);

	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateCategory(@RequestBody Category updatedCategory) throws RecordNotUpdatedException, RecordExistException, RecordNotCreatedException {

		ApiSuccessResponse response = new ApiSuccessResponse();

		String message = this.categoryService.updateCategory(updatedCategory);

		response.setMessage("Successfully updated category. ");
		response.setHttpStatus(String.valueOf(HttpStatus.ACCEPTED));
		response.setHttpStatusCode(202);
		response.setBody(message);
		response.setError(false);
		response.setSuccess(true);

		return ResponseEntity.status(HttpStatus.ACCEPTED).header("status", String.valueOf(HttpStatus.ACCEPTED))
				.body(response);

	}

}
