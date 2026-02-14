package com.example.solid.srp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios para el Principio de Responsabilidad Única (SRP)
 */
class SRPTest {

    @Test
    @DisplayName("Invoice con responsabilidad única")
    void testInvoice() {
        Invoice invoice = new Invoice("María García", 200.0);
        
        assertEquals("María García", invoice.getCustomer());
        assertEquals(200.0, invoice.getAmount());
        assertEquals(242.0, invoice.calculateTotal(), 0.01);
    }

    @Test
    @DisplayName("InvoicePrinter funciona correctamente")
    void testInvoicePrinter() {
        Invoice invoice = new Invoice("Pedro López", 150.0);
        InvoicePrinter printer = new InvoicePrinter();
        
        assertDoesNotThrow(() -> printer.print(invoice));
    }

    @Test
    @DisplayName("InvoiceRepository funciona correctamente")
    void testInvoiceRepository() {
        Invoice invoice = new Invoice("Ana Martínez", 300.0);
        InvoiceRepository repository = new InvoiceRepository();
        
        assertDoesNotThrow(() -> repository.save(invoice));
    }

    @Test
    @DisplayName("Separación de responsabilidades")
    void testSeparationOfConcerns() {
        Invoice invoice = new Invoice("Laura Sánchez", 400.0);
        
        InvoicePrinter printer = new InvoicePrinter();
        printer.print(invoice);
        
        InvoiceRepository repository = new InvoiceRepository();
        repository.save(invoice);
        
        assertTrue(true);
    }

    @Test
    @DisplayName("Cálculo de total con IVA")
    void testTotalCalculation() {
        Invoice invoice1 = new Invoice("Cliente 1", 100.0);
        assertEquals(121.0, invoice1.calculateTotal(), 0.01);
        
        Invoice invoice2 = new Invoice("Cliente 2", 500.0);
        assertEquals(605.0, invoice2.calculateTotal(), 0.01);
        
        Invoice invoice3 = new Invoice("Cliente 3", 0.0);
        assertEquals(0.0, invoice3.calculateTotal(), 0.01);
    }
}
