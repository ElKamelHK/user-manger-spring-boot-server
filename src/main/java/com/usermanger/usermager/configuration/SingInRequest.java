package com.usermanger.usermager.configuration;

public class SingInRequest {

	private String username;
	private String password;
	
	public SingInRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public SingInRequest() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
