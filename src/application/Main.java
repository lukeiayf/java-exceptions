package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room number: ");
        int number = sc.nextInt();
        System.out.println("Check-in (DD/MM/YYYY)");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Check-out (DD/MM/YYYY)");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Check-out date must be after Check-in date");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation data: " + reservation);

            System.out.println();
            System.out.println("Update the reservation");
            System.out.println("Check-in (DD/MM/YYYY)");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-out (DD/MM/YYYY)");
            checkOut = sdf.parse(sc.next());

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println("Error in reservation: " + error);
            } else {
                System.out.println("Reservation data: " + reservation);
            }

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation data: " + reservation);
        }

        sc.close();
    }
}