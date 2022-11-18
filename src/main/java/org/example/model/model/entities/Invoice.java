package org.example.model.model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Invoice {
    private Double basicPayment;
    private Double tax;

    public Invoice(){}

    public Invoice(Double basicPayment, Double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    public Double getTotalPayment() {
        return getBasicPayment() + getTax();
    }
}
