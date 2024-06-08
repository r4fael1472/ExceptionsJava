/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trycatch;

/**
 *
 * @author Usuario
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
public class TryCatch{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.print("Room number: ");
            int number = s.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(s.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(s.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(s.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(s.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: "+ reservation);
        }
        catch (ParseException e){
            System.out.println("Invalid date format");
        }
        catch (DomainException e){
            System.out.println("Erro in reservation: "+ e.getMessage());
        }
        catch (RuntimeException e){ //Tipo de exceção genérico
            System.out.println("Unexpected error");
        }
    }
}