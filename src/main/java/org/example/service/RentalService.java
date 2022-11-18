package org.example.service;

import lombok.Getter;
import lombok.Setter;
import org.example.model.model.entities.CarRental;
import org.example.model.model.entities.Invoice;

import java.time.Duration;

@Getter
@Setter
public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;
    private BrazilTaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {

        Double minutes = Double.valueOf(Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes());
        Double hours = minutes / 60.0;

        Double basic;
        Double tax;
        if (hours < 12.0) {
            basic = pricePerHour * Math.ceil(hours);
        } else {
            basic = pricePerDay * Math.ceil(hours / 24.0);
        }

        tax = taxService.tax(basic);

        carRental.setInvoice(new Invoice(basic, tax));
    }
}
