package org.example.model.model.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
public class CarRental {
    private LocalDateTime start;
    private LocalDateTime finish;
    private Vehicle vehicle;
    private Invoice invoice;

    public CarRental() {
    }

    public CarRental(LocalDateTime start, LocalDateTime finish, Vehicle vehicle) {
        this.start = start;
        this.finish = finish;
        this.vehicle = vehicle;
    }
}
