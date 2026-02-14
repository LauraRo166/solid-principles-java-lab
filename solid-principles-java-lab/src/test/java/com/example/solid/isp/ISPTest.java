package com.example.solid.isp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para el Principio de Segregación de Interfaces (ISP)
 */
class ISPTest {

    @Test
    @DisplayName("Developer solo implementa interfaces necesarias")
    void testGoodExampleDeveloper() {
        Developer developer = new Developer();
        
        assertTrue(developer instanceof Workable);
        assertDoesNotThrow(() -> developer.work());
    }

    @Test
    @DisplayName("Interfaces específicas permiten composición")
    void testInterfaceSegregation() {
        Workable developer = new Developer();
        assertDoesNotThrow(() -> developer.work());
    }

    @Test
    @DisplayName("Cliente solo depende de las interfaces que necesita")
    void testClientDependsOnlyOnNeededInterfaces() {
        Workable worker = new Developer();
        assertDoesNotThrow(() -> worker.work());
        
        assertFalse(worker instanceof Eatable);
    }
}
