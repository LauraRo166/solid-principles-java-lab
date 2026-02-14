package com.example.solid.isp;

public class Developer implements Workable {
    
    @Override
    public void work() {
        System.out.println("Escribiendo código...");
    }
}

public interface Workable {
    void work();
}

public interface Eatable {
    void eat();
}