package com.example.solid.ocp;

public class DiscountCalculator {
    private DiscountStrategy discountStrategy;

    public DiscountCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateDiscount(double price) {
        return discountStrategy.calculateDiscount(price);
    }
}

public interface DiscountStrategy {
    double calculateDiscount(double price);
}

public class NoDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double price) {
        return 0.0;
    }
}

public class RegularCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double price) {
        return price * 0.10;
    }
}

public class VipCustomerDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double price) {
        return price * 0.20;
    }
}