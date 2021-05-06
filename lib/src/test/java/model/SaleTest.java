package model;

import integration.Discount;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    @Test
    void testGetTotal() {
        Sale sale = new Sale();
        sale.setTotalWithTax(150.0);
        Discount discount = new Discount();
        discount.setDiscount(50.0);
        sale.setDiscount(discount);

        assertEquals(100, sale.getTotal());

    }

}