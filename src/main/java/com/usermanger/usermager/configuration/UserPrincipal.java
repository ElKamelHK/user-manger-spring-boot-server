package com.usermanger.usermager.configuration;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.usermanger.usermager.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPrincipal implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private String firstName;
    private String lastName;
    private String username;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String email;
    private Integer age;
	private String country;
	private String cin;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	public UserPrincipal(Long id, String firstName, String lastName, String username, String password,
			Integer age, String country, String cin) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		 
		this.age = age;
		this.country = country;
		this.cin = cin;
	}
	public UserPrincipal() {
		super();
		// TODO Auto-generated constructor stub
	}
 
 
	 public static UserPrincipal create(User user) {
	        

	        return new UserPrincipal(
	                user.getId(),
	                user.getFirstName(),
	                user.getLastname(),
	                user.getUsername(),
	                
	                user.getPassword(),
	                user.getAge(),
	                user.getCountry(),
	                user.getCin() 
	                
	               
	                 
	        );
	    }
}