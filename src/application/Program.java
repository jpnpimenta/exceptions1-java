package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number : ");
		int roomNumber = sc.nextInt();
		System.out.print("CheckIn Date (dd/mm/aaaa): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("CheckOut Date (dd/mm/aaaa): ");
		Date checkOut = sdf.parse(sc.next());
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation : " + reservation);
			
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Checkin Date (dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Checkout Date (dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());
            
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				 System.out.println("Error in reservation: Reservation dates for update must be future date");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else 	{
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation : " + reservation);
			}
			
			
			
		}
		
		
		
		sc.close();
		

	}

}