package com.usermanger.usermager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanger.usermager.model.User;
import com.usermanger.usermager.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/user-manager")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController( UserService userService) {
		
		this.userService=userService;
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("findAll")
	public List<User> findAllUsers()
	{
		return this.userService.findAll();
	}
	
	

}
