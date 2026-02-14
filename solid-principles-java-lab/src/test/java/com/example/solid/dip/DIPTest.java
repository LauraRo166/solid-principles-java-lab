package com.example.solid.dip;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para el Principio de Inversión de Dependencias (DIP)
 */
class DIPTest {

    @Test
    @DisplayName("OrderProcessor con MySQLDatabase")
    void testGoodExampleWithMySQL() {
        Database mysql = new MySQLDatabase();
        OrderProcessor processor = new OrderProcessor(mysql);
        
        assertDoesNotThrow(() -> processor.processOrder("Pedido #123"));
    }

    @Test
    @DisplayName("OrderProcessor con PostgreSQLDatabase")
    void testGoodExampleWithPostgreSQL() {
        Database postgres = new PostgreSQLDatabase();
        OrderProcessor processor = new OrderProcessor(postgres);
        
        assertDoesNotThrow(() -> processor.processOrder("Pedido #456"));
    }

    @Test
    @DisplayName("OrderProcessor se puede crear con cualquier implementación de Database")
    void testOrderProcessorAcceptsDatabaseInterface() {
        Database mysql = new MySQLDatabase();
        OrderProcessor processor1 = new OrderProcessor(mysql);
        assertNotNull(processor1);
        
        Database postgres = new PostgreSQLDatabase();
        OrderProcessor processor2 = new OrderProcessor(postgres);
        assertNotNull(processor2);
    }

    @Test
    @DisplayName("Módulos de alto nivel no dependen de bajo nivel")
    void testHighLevelDoesNotDependOnLowLevel() {
        Database db1 = new MySQLDatabase();
        Database db2 = new PostgreSQLDatabase();
        
        OrderProcessor processor1 = new OrderProcessor(db1);
        assertDoesNotThrow(() -> processor1.processOrder("Pedido MySQL"));
        
        OrderProcessor processor2 = new OrderProcessor(db2);
        assertDoesNotThrow(() -> processor2.processOrder("Pedido PostgreSQL"));
    }
}
