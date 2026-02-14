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

public interface Database {
    void saveOrder(String order);
}

public class MySQLDatabase implements Database {
    @Override
    public void saveOrder(String order) {
        System.out.println("Guardando pedido en MySQL: " + order);
    }
}

public class PostgreSQLDatabase implements Database {
    @Override
    public void saveOrder(String order) {
        System.out.println("Guardando pedido en PostgreSQL: " + order);
    }
}