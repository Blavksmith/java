package com.myapp;

import java.util.UUID;

public class User extends Display{
	protected String username;
	protected String password;
	protected String token;
	
	public void getToken() {
		token = UUID.randomUUID().toString();
	}

	public void doRegister(String username, String password) {
		this.username = username;
		this.password = password;
		getToken();
		System.out.println("User and Password was added, and the token generated for the session");
	}
	
	void showNotification() {
		System.out.println("Created by " + this.username);
		showToken(token);
	}
}
