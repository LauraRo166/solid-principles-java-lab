package com.example.solid.srp;

public class Invoice {
    private String customer;
    private double amount;

    public Invoice(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public String getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }

    public double calculateTotal() {
        return amount * 1.21;
    }
}

public class InvoicePrinter {
    public void print(Invoice invoice) {
        System.out.println("Factura para: " + invoice.getCustomer());
        System.out.println("Total: " + invoice.calculateTotal());
    }
}

public class InvoiceRepository {
    public void save(Invoice invoice) {
        System.out.println("Guardando factura para " + invoice.getCustomer() + "...");
    }
}