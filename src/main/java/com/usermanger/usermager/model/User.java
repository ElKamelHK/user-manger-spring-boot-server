package com.usermanger.usermager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Long id;
	private String lastname;
	private String firstName;
	private Integer age;
	private String country;
	@Override
	public String toString() {
		return "User [id=" + id + ", lastname=" + lastname + ", firstName=" + firstName + ", age=" + age + ", country="
				+ country + "]";
	}
	
	
	

}
