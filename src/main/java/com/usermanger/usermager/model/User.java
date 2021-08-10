package com.usermanger.usermager.model;

 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
