package com.usermanger.usermager.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 
import com.usermanger.usermager.model.User;
import com.usermanger.usermager.repository.UserRepository;
import com.usermanger.usermager.service.UserService;

 



@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

   


	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 User user = userRepository.findByUsername(username)
	                .orElseThrow(() ->
	                        new UsernameNotFoundException("User not found with username or email : " + username)
	        );
		return null;
	}
	
	@Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id)
        		.orElseThrow(() ->
                new UsernameNotFoundException("User not found with id or email : " + id)
        				);

        return UserPrincipal.create(user);
    }
}
