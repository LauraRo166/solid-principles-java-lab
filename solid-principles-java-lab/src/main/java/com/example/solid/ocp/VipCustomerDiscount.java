package com.example.solid.ocp;

public class VipCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double price) {
        return price * 0.20;
    }
}
