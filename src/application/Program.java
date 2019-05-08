package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.exceptions.DomainException;
import model.entities.Reservation;

public class Program {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room Number : ");
			int roomNumber = sc.nextInt();
			System.out.print("CheckIn Date (dd/mm/aaaa): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("CheckOut Date (dd/mm/aaaa): ");
			Date checkOut = sdf.parse(sc.next());
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
	
			System.out.println("Reservation : " + reservation);
			
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Checkin Date (dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Checkout Date (dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());
		    reservation.updateDates(checkIn, checkOut);
	
		    System.out.println("Reservation : " + reservation);
		} catch (ParseException e) {
			System.out.println("Invalid date format.");
		} catch (DomainException e) {
			System.out.println("Error in reservation : " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected Error.");
		}
		
			
			
		
		
		
		sc.close();
		

	}

}
