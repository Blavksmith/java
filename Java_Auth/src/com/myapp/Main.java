package com.myapp;
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		User userSatu = new User();
//		System.out.print("Masukkan username : ");
//		String username = sc.nextLine();
//		System.out.print("Masukkan password : ");
//		String password = sc.nextLine();
//		
//		userSatu.doRegister(username, password);
//		userSatu.showNotification();
		
		
		User userDua = new Admin();
		System.out.print("Masukkan username : ");
		String username = sc.nextLine();
		System.out.print("Masukkan password : ");
		String password = sc.nextLine();
		
		userDua.doRegister(username, password);
		userDua.showNotification();
		
		
	}
}
