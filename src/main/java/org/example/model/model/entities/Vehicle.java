package org.example.model.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    private String model;

    public Vehicle(){
    }

    public Vehicle(String model) {
        this.model = model;
    }
}
