package com.usermanger.usermager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanger.usermager.model.User;
import com.usermanger.usermager.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
@Autowired
	private UserRepository  userRepository;
	
	 

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}

	public Optional<User> findById(Long id) {
		Optional<User> optUser =this.userRepository.findById(id);
		
		return optUser;
	}

	 

}
