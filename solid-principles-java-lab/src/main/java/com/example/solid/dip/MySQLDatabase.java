package com.example.solid.dip;

public class MySQLDatabase implements Database {
    @Override
    public void saveOrder(String order) {
        System.out.println("Guardando pedido en MySQL: " + order);
    }
}
