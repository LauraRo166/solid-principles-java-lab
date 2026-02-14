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

public interface Vehicle {
    void drive();
}

public interface Rechargeable {
    void recharge();
}

public interface Refuelable {
    void refuel();
}