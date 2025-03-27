package com.meinHotel;
import java.util.*;

public class GuestController {
	
	public static void addNewGuest(ArrayList<Guest> guests, Scanner sc) {
		System.out.println("Enter the name : ");
		String name = sc.next();
		
		System.out.println("Enter the email : ");
		String email = sc.next();
		
		System.out.println("Enter the discount : ");
		int discount = sc.nextInt();
		
		Guest guest = new Guest(guests.size(), name, email, discount);
		guests.add(guest);
		
		System.out.println("New Guest added successfully");
	}

	public static void showAllGuest(ArrayList<Guest> guests) {
		for(Guest guest : guests) {
			System.out.println("------------------");
			guest.printAll();
			System.out.println("------------------");
			System.out.println("");
		}
	}
	
	public static void searchGuest(ArrayList<Guest> guests, Scanner sc) {
		System.out.println("Enter the name : ");
		String name = sc.next();
		for(Guest guest : guests) {
			if(guest.getName().equals(name)) {
				guest.printAll();
			}
		}
	}
	
	
	public static void editGuest(ArrayList<Guest> guests, Scanner sc) {
		System.out.println("Enter id : \n [If you want to see list of the data (Type -1)]");
		int i = sc.nextInt();
		int id = 0;
		
		if(i == -1) {
			showAllGuest(guests);
			System.out.println("Enter room id : ");
			int j = sc.nextInt();
			id = j;
		}else {
			id = i;
		}
		
//		Guest guest = getById(id, guests);  id -> mengikuti idx array
		Guest guest = guests.get(id);
		
		System.out.println("Enter the name : \n (-1 to keep it)");
		String name = sc.next();
		if(name.equals("-1")) name = guest.getName();
		
		System.out.println("Enter the capacity : \n (-1 to keep it)");
		String email = sc.next();
		if(email.equals("-1")) email = guest.getEmail();
		
		System.out.println("Enter the type : \n (-1 to keep it)");
		int discount = sc.nextInt();
		if(discount == -1) discount = guest.getDiscount();
		
		guest.setName(name);
		guest.setEmail(email);
		guest.setDiscount(discount);
		
		// Masukkan ke array list
		guests.set(id, guest);
	
	}
	
	
}
