package com.example.solid.lsp;

public class ElectricCar implements Vehicle, Rechargeable {
    
    @Override
    public void drive() {
        System.out.println("Auto eléctrico conduciendo");
    }

    @Override
    public void recharge() {
        System.out.println("Recargando batería...");
    }
}
