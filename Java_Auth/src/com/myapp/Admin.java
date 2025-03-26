package com.myapp;

public class Admin extends User{
	
	private final String role = "admin";

	@Override
	void showNotification() {
		System.out.println("Created by " + role);
		showToken(token);
	}
	
}
