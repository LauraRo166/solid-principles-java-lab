package com.example.solid.ocp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para el Principio Abierto/Cerrado (OCP)
 */
class OCPTest {

    @Test
    @DisplayName("Extensible sin modificación con NoDiscount")
    void testGoodExampleNoDiscount() {
        DiscountStrategy noDiscount = new NoDiscount();
        DiscountCalculator calculator = new DiscountCalculator(noDiscount);
        
        assertEquals(0.0, calculator.calculateDiscount(100.0), 0.01);
        assertEquals(0.0, calculator.calculateDiscount(500.0), 0.01);
    }

    @Test
    @DisplayName("RegularCustomerDiscount")
    void testGoodExampleRegularDiscount() {
        DiscountStrategy regularDiscount = new RegularCustomerDiscount();
        DiscountCalculator calculator = new DiscountCalculator(regularDiscount);
        
        assertEquals(10.0, calculator.calculateDiscount(100.0), 0.01);
        assertEquals(50.0, calculator.calculateDiscount(500.0), 0.01);
    }

    @Test
    @DisplayName("VipCustomerDiscount")
    void testGoodExampleVipDiscount() {
        DiscountStrategy vipDiscount = new VipCustomerDiscount();
        DiscountCalculator calculator = new DiscountCalculator(vipDiscount);
        
        assertEquals(20.0, calculator.calculateDiscount(100.0), 0.01);
        assertEquals(100.0, calculator.calculateDiscount(500.0), 0.01);
    }

    @Test
    @DisplayName("Cambio dinámico de estrategia")
    void testStrategyChange() {
        DiscountCalculator calculator = new DiscountCalculator(new NoDiscount());
        assertEquals(0.0, calculator.calculateDiscount(100.0), 0.01);
        
        calculator.setDiscountStrategy(new RegularCustomerDiscount());
        assertEquals(10.0, calculator.calculateDiscount(100.0), 0.01);
        
        calculator.setDiscountStrategy(new VipCustomerDiscount());
        assertEquals(20.0, calculator.calculateDiscount(100.0), 0.01);
    }

    @Test
    @DisplayName("Agregar nueva estrategia sin modificar código existente")
    void testExtensibilityWithoutModification() {
        DiscountStrategy customDiscount = new DiscountStrategy() {
            @Override
            public double calculateDiscount(double price) {
                return price * 0.5;
            }
        };
        
        DiscountCalculator calculator = new DiscountCalculator(customDiscount);
        assertEquals(50.0, calculator.calculateDiscount(100.0), 0.01);        
    }
}
