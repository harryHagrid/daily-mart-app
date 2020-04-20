package com.training.dailymartapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.dailymartapi.exception.RecordNotCreatedException;
import com.training.dailymartapi.model.AppUser;
import com.training.dailymartapi.restApiConfig.model.ApiSuccessResponse;
import com.training.dailymartapi.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public ResponseEntity<?> saveUser(@RequestBody AppUser user) throws RecordNotCreatedException {

		ApiSuccessResponse response = new ApiSuccessResponse();
		String message = this.userService.saveUser(user);
		response.setMessage("Successfully saved the user - " + user.getName());
		response.setHttpStatus(String.valueOf(HttpStatus.CREATED));
		response.setHttpStatusCode(201);

		response.setBody(message);
		response.setError(false);
		response.setSuccess(true);

		return ResponseEntity.status(HttpStatus.OK).header("status", String.valueOf(HttpStatus.CREATED)).body(response);

	}

}
