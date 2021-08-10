package com.usermanger.usermager.service;

import java.util.List;
import java.util.Optional;

import com.usermanger.usermager.model.User;


public interface UserService {

	public List<User> findAll();
	public Optional <User> findById(Long id);
	 
	
}
