package com.example.solid.lsp;

public class GasolineCar implements Vehicle, Refuelable {
    
    @Override
    public void drive() {
        System.out.println("Auto de gasolina conduciendo");
    }

    @Override
    public void refuel() {
        System.out.println("Recargando combustible...");
    }
}
