package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    private Double runningTotal;

    @BeforeAll
    void startUpThings() {
        Item item = new Item();
        item.setPrice(50.0);
        item.setVat(25.0);
        Integer amount = 5;
        updateRunningTotal(item, amount);

    }

    @Test
    void updateRunningTotal(Item item, Integer amountOfItems) {
        runningTotal += item.getPrice() * amountOfItems * item.getVat();
        assertEquals(312.5, runningTotal);
    }

}