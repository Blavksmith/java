package com.myapp;

public abstract class Display {
	abstract void showNotification();
	
	void showToken(String token) {
		System.out.println("Token generated :" + token);
	}
}
