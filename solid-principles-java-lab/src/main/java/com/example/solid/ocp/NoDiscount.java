package com.example.solid.ocp;

public class NoDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double price) {
        return 0.0;
    }
}
