package com.training.dailymartapi.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.training.dailymartapi.exception.RecordNotCreatedException;
import com.training.dailymartapi.exception.RecordNotFoundException;
import com.training.dailymartapi.model.AppUser;
import com.training.dailymartapi.repository.AppUserRepository;
import com.training.dailymartapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private AppUserRepository userRepo;

	@Override
	public String saveUser(AppUser user) throws RecordNotCreatedException {
		try {
			this.userRepo.save(user);
			return "User saved successfully";
		} catch (DataIntegrityViolationException e) {
			throw new RecordNotCreatedException("Something went wrong in adding user from service", e);
		} catch (DataAccessException e) {
			throw new RecordNotCreatedException("Something went wrong in accessing db from service", e);
		}

	}

	@Override
	public List<AppUser> getAllUsers() throws RecordNotFoundException {
		try {
			return this.userRepo.findAll();
		} catch (DataAccessException e) {
			throw new RecordNotFoundException("Something went wrong in getting all users from service", e);
		}
	}

	@Override
	public AppUser getUserById(long id) throws RecordNotFoundException {

		String message = "";
		try {
			return this.userRepo.findById(id).get();
		} catch (NoSuchElementException e) {
			message = "Sorry..No user found by this id.";
			throw new RecordNotFoundException(message , e);
		} catch (DataAccessException e) {
			message = "Sorry.. something went wrong in db";
			throw new RecordNotFoundException(message , e);
		}
	}

}
