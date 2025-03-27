package com.meinHotel;
import java.util.*;


public class Main {
	private static ArrayList<Guest> guests;
	private static ArrayList<Room> rooms;
	private static ArrayList<Employee> employees;
	private static ArrayList<Reservation> reservations;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		Main main = new Main();
//		main.reservations = new ArrayList<>();
		guests = new ArrayList<>();
		employees = new ArrayList<>();
		rooms = new ArrayList<>();
		reservations = new ArrayList<>();
		
		int i = 0;
		
		do {
			System.out.println("Welcome to Hotel Management System");
			System.out.println("- - - - - - - - - - - - - - - - - -");
			System.out.println("1. Add new room");
			System.out.println("2. Show all rooms");
			System.out.println("3. Edit room");
			System.out.println("4. Add new guest");
			System.out.println("5. Show all guest");
			System.out.println("6. Search guest by name");
			System.out.println("7. Edit guest data");
			System.out.println("8. Create new reservation");
			System.out.println("9. Show all reservation");
			System.out.println("10. Get reservation by guest name");
			System.out.println("11. Get reservation by id");
			System.out.println("12. Edit reservation");
			System.out.println("13. Add new employee");
			System.out.println("14. Show all employee");
			System.out.println("15. Edit employee");
			System.out.println("16. Quit");
			
			
			System.out.println("Input the option of menu : ");
			i = sc.nextInt();
			
			
			switch(i) {
			case 1:
				RoomController.addNewRoom(rooms, sc);
				break;
			case 2:
				RoomController.showAllRoom(rooms);
				break;
			case 3:
				RoomController.editRoom(rooms, sc);
				break;
			case 4:
				GuestController.addNewGuest(guests, sc);
				break;
			case 5:
				GuestController.showAllGuest(guests);
				break;
			case 6:
				GuestController.searchGuest(guests, sc);
				break;
			case 7:
			
			}
		}while(i <= 16);
		
			
		
		

	}

}
