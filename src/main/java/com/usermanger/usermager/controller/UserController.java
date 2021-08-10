package com.usermanger.usermager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@GetMapping("findById/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id)
	{
		Optional<User>optUser=this.userService.findById(id);
		if(optUser.isPresent())
		{
			return new ResponseEntity<User>(optUser.get(),HttpStatus.OK);
		}else
		{
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("add")
	public ResponseEntity<?>  addNewUser(@RequestBody User user)
	{
		return this.userService.addNewUser(user);
	}

}
