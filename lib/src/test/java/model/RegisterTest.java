package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {


    @Test
    void calculateChange() {
        Sale sale = new Sale();
        sale.setTotalWithTax(150.0);
        Payment payment = new Payment(200.0);
        Register register = new Register();
        assertEquals(50.0, register.calculateChange(payment, sale));
    }
}