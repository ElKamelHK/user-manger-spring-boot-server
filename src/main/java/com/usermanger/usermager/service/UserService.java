package com.usermanger.usermager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.usermanger.usermager.model.User;


public interface UserService extends UserDetailsService {

	public List<User> findAll();
	public Optional <User> findById(Long id);
	public User findByUsername(String username);
	public Optional <User> findByCin(String cin);
	public ResponseEntity<?>  addNewUser(User user);
	public ResponseEntity<?>  updateUser(User user,Long id);
	public ResponseEntity<?>  deletewUserById(Long id);
	public User save(User user);
	
	
}
