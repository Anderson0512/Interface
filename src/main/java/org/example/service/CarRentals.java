package org.example.service;

import org.example.model.model.entities.CarRental;
import org.example.model.model.entities.Invoice;
import org.example.model.model.entities.Vehicle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class CarRentals {
    public static void carRental() {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter Rent Data:");
        System.out.print("Car Model: ");
        String model = sc.nextLine();
        System.out.print("Removal (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), dtf);
        System.out.print("Return (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), dtf);

        CarRental carRental = new CarRental(start,finish,new Vehicle(model));

        System.out.print("Enter with price hour: ");
        Double priceHour = sc.nextDouble();
        System.out.print("Enter with price day: ");
        Double priceDay = sc.nextDouble();

        RentalService rentalService = new RentalService(priceHour, priceDay,new BrazilTaxService());
        rentalService.processInvoice(carRental);

        System.out.println();
        System.out.println("INVOICE");
        System.out.println("Basic Payment: " + carRental.getInvoice().getBasicPayment());
        System.out.println("Tax: " + carRental.getInvoice().getTax());
        System.out.println("Payment Total: " + carRental.getInvoice().getTotalPayment());


    }
}
