package com.usermanger.usermager.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
import com.usermanger.usermager.model.User;
import com.usermanger.usermager.repository.UserRepository;
import com.usermanger.usermager.service.UserService;

@RestController
@RequestMapping("api/user-manager/auth")
public class AuthController {
 
		
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	 @Autowired
	    AuthenticationManager authenticationManager;	
	 @Autowired
	    JwtTokenProvider tokenProvider;
	@PostMapping(value= {"","/","signIn","sign-in"})
	public JwtResponse signIn(@RequestBody  SingInRequest loginRequest)
	{
		System.out.println("loginRequest.getUsername()"+loginRequest.getUsername()+"loginRequest.getPassword()"+loginRequest.getPassword());
		 Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                		loginRequest.getUsername(),
	                        loginRequest.getPassword()
	                )
	        );

	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        System.out.println("authentication");
	        String jwt = tokenProvider.generateToken(authentication);
		      if(authentication.isAuthenticated())
		      {
		    	  User user = userRepository.findByUsername(loginRequest.getUsername())
		                  .orElseThrow(() ->
		                          new UsernameNotFoundException("User not found with username or email : " + loginRequest.getUsername())
		          );
		    	  
		    	System.out.println("authentication");
		    	  return null;
		     
	        
	    }else
	    {System.out.println("nn authentication");
	    	 return null;
	    }
	}

}
