package com.usermanger.usermager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.usermanger.usermager.model.User;


public interface UserService {

	public List<User> findAll();
	public Optional <User> findById(Long id);
	public Optional <User> findByCin(String cin);
	public ResponseEntity<?>  addNewUser(User user);
	public ResponseEntity<?>  updateUser(User user,Long id);
	public ResponseEntity<?>  deletewUserById(Long id);
	public User save(User user);
	
	
}
