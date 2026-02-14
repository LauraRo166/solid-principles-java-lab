package com.example.solid.ocp;

public class RegularCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double price) {
        return price * 0.10;
    }
}
