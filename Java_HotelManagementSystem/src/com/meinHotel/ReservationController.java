package com.meinHotel;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReservationController {
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public static void createReservation(ArrayList<Guest> guests, ArrayList<Room> rooms, ArrayList<Reservation> reservations, Scanner sc) {
		
		System.out.println("Enter arrival date (yyyy-MM-dd) : ");
		String arrDate = sc.next();
		System.out.println("Enter arrival date (yyyy-MM-dd) : ");
		String depDate = sc.next();
		
		System.out.println("Enter guest id:\n Search Guest by Name");
		int guestId = sc.nextInt();
		if(guestId == -1) {
			GuestController.searchGuest(guests, sc);
			System.out.println("Enter guest id : ");
			guestId = sc.nextInt();
		}
		
		System.out.println("Enter room id\n Show all room");
		int roomId = sc.nextInt();
		if(roomId == -1) {
			RoomController.showAllRoom(rooms);
			System.out.println("Enter room id :");
			roomId = sc.nextInt();
		}
		
		// Mengubah date jadi localDate
		LocalDate arrivalDate = LocalDate.parse(arrDate, formatter);
		LocalDate departureDate = LocalDate.parse(depDate, formatter);
		
		// Mencari room
		Guest guest = guests.get(guestId);
		Room room = RoomController.getRoomById(roomId, rooms);
		if(room.isReserved(arrivalDate, departureDate)) {
			System.out.println("This room is reserved");
			return;
		}else {
			int days = Period.between(arrivalDate, departureDate).getDays();
			double sum = days * room.getPrice();
			double total = sum - sum*guest.getDiscount()/100;
			System.out.println("Total before discount:" + sum);
			System.out.println("Total after discount: " + total);
			
			System.out.println("Will you pay now?\n1.Yes\n2.No");
			String status = "";
			int choiceStatus = sc.nextInt();
			if(choiceStatus == 1) {
				status = "Paid";
			}else {
				status = "Room has been reserved!";
			}
			
			Reservation newReservation = new Reservation(arrivalDate, departureDate, total, status, guest, room);
			newReservation.printAll();
			reservations.add(newReservation);
			System.out.println("Reservation setted up! Have a nice one :) ");
			
		}
			
	}
	
	public static void showAllReservation(ArrayList<Reservation> reservations) {
		for(Reservation r : reservations) {
			System.out.println("-------------------------");
			System.out.println("Arrival Date : " + r.getArrivalDatetoString());
			System.out.println("Departure Date : " + r.getDepartureDatetoString());
			System.out.println("Guest Name : " + r.getGuest().getName());
			System.out.println("Room : " + r.getRoom().getId());
			System.out.println("Price : " + r.getPrice());
			System.out.println("Status : " + r.getStatus());
			System.out.println("-------------------------");
			
		}
	}
	
	public static void getReservationByName(ArrayList<Reservation> reservations, Scanner sc) {
		System.out.println("Enter Guest Name: ");
		String name = sc.next();
		for(Reservation reservation : reservations) {
			if(reservation.getGuest().getName().equals(name)) {
				reservation.printAll();
			}
		}
		
	}
	
	public static void getReservationById(ArrayList<Reservation> reservations, Scanner sc) {
		System.out.println("Enter Guest Id: ");
		int id = sc.nextInt();
		for(Reservation reservation : reservations) {
			if(reservation.getGuest().getId() == id) {
				reservation.printAll();
			}
		}
		
	}
	
	public static void editReservation(ArrayList<Guest> guests, ArrayList<Room> rooms, ArrayList<Reservation> reservations, Scanner sc) {
		System.out.println("Enter reservation id : \n [If you want to see list of the data (Type -1)]");
		int i = sc.nextInt();
		int id = 0;
		
		if(i == -1) {
			showAllReservation(reservations);
			System.out.println("Enter reservation id : ");
			int j = sc.nextInt();
			id = j;
		}else {
			id = i;
		}
		
		Reservation reservation = reservations.get(id);
		
		
		// Input
		System.out.println("Enter arrival date (yyyy-MM-dd) : ");
		String arrDate = sc.next();
		
		System.out.println("Enter arrival date (yyyy-MM-dd) : ");
		String depDate = sc.next();
		
		System.out.println("Enter room id : ");
		int roomId = sc.nextInt();
		
		LocalDate arrivalDate = LocalDate.parse(arrDate, formatter);
		LocalDate departureDate = LocalDate.parse(depDate, formatter);
		
		Guest guest = reservation.getGuest();
		Room room = RoomController.getRoomById(roomId, rooms);
		if(room.isReserved(arrivalDate, departureDate)) {
			System.out.println("This room is reserved");
			return;
		}else {
			int days = Period.between(arrivalDate, departureDate).getDays();
			double sum = days * room.getPrice();
			double total = sum - sum*guest.getDiscount()/100;
			System.out.println("Total before discount:" + sum);
			System.out.println("Total after discount: " + total);
			
			System.out.println("Will you pay now?\n1.Yes\n2.No");
			String status = "";
			int choiceStatus = sc.nextInt();
			if(choiceStatus == 1) {
				status = "Paid";
			}else {
				status = "Room has been reserved!";
			}
			
		reservation.setArrivalDate(arrivalDate);
		reservation.setDepartureDate(departureDate);
		reservation.setRoom(room);
		reservation.setStatus(status);
		reservation.setPrice(total);
		
		reservations.add(id, reservation);
	}
	}
}