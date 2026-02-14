package com.example.solid.dip;

public class OrderProcessor {
    private Database database;

    public OrderProcessor(Database database) {
        this.database = database;
    }

    public void processOrder(String order) {
        database.saveOrder(order);
    }
}
