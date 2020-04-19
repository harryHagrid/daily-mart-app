package com.training.dailymartapi.service;

import java.util.List;

import com.training.dailymartapi.exception.RecordNotCreatedException;
import com.training.dailymartapi.exception.RecordNotFoundException;
import com.training.dailymartapi.model.AppUser;

public interface UserService {
	
	String saveUser(AppUser user) throws RecordNotCreatedException;
	List<AppUser> getAllUsers() throws RecordNotFoundException;
	AppUser getUserById(long id) throws RecordNotFoundException;
	

}
