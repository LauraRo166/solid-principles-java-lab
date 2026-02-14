package com.example.solid.lsp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para el Principio de Sustitución de Liskov (LSP)
 */
class LSPTest {

    @Test
    @DisplayName("GasolineCar implementa interfaces correctas")
    void testGoodExampleGasolineCar() {
        GasolineCar gasolineCar = new GasolineCar();
        
        assertTrue(gasolineCar instanceof Vehicle);
        assertTrue(gasolineCar instanceof Refuelable);
        assertDoesNotThrow(() -> gasolineCar.drive());
        assertDoesNotThrow(() -> gasolineCar.refuel());
    }

    @Test
    @DisplayName("ElectricCar implementa interfaces correctas")
    void testGoodExampleElectricCar() {
        ElectricCar electricCar = new ElectricCar();
        
        assertTrue(electricCar instanceof Vehicle);
        assertTrue(electricCar instanceof Rechargeable);
        assertDoesNotThrow(() -> electricCar.drive());
        assertDoesNotThrow(() -> electricCar.recharge());
    }

    @Test
    @DisplayName("Todos los vehículos pueden drive() sin problemas")
    void testPolymorphicDrive() {
        Vehicle gasoline = new GasolineCar();
        Vehicle electric = new ElectricCar();
        
        assertDoesNotThrow(() -> gasoline.drive());
        assertDoesNotThrow(() -> electric.drive());
    }

    @Test
    @DisplayName("Refuelable solo para vehículos apropiados")
    void testRefuelableInterface() {
        GasolineCar gasolineCar = new GasolineCar();
        
        assertTrue(gasolineCar instanceof Refuelable);
        assertDoesNotThrow(() -> ((Refuelable) gasolineCar).refuel());
    }

    @Test
    @DisplayName("Rechargeable solo para vehículos apropiados")
    void testRechargeableInterface() {
        ElectricCar electricCar = new ElectricCar();
        
        assertTrue(electricCar instanceof Rechargeable);
        assertDoesNotThrow(() -> ((Rechargeable) electricCar).recharge());
    }

    @Test
    @DisplayName("Sustitución sin efectos secundarios")
    void testLiskovSubstitutionPrinciple() {
        Vehicle[] vehicles = {
            new GasolineCar(),
            new ElectricCar()
        };
        
        for (Vehicle vehicle : vehicles) {
            assertDoesNotThrow(() -> vehicle.drive());
        }
    }
}
