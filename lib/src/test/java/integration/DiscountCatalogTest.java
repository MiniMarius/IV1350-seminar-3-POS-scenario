package integration;

import model.Item;
import model.Sale;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DiscountCatalogTest {

    @Test
    void testCalculateDiscount() {
        Integer idNumber = 8;
        DiscountCatalog discountCatalog = new DiscountCatalog(idNumber);

        ArrayList<Item> itemsInStock = new ArrayList<>();

        itemsInStock.add( new Item("Kebab", "A bag of kebab-meat, 400 g", 135.0, 10.0, 8, 1));
        itemsInStock.add( new Item("Nuggets extra thick", "A bag of chicken-nuggets, 20 pieces", 50.0, 25.0, 3, 1));
        itemsInStock.add( new Item("Sour Apple candy", "A bag of candy, green and yellow", 60.0, 25.0, 5, 1));
        itemsInStock.add( new Item("ice-cream superIcy", "A big tub of ice cream", 22.0, 25.0, 6, 1));

        Sale sale = new Sale();
        sale.setTotalWithTax(100.0);
        sale.setScannedItems(itemsInStock);
        Discount result = discountCatalog.calculateDiscount(idNumber, sale);

        assertEquals(20, result.getDiscount());
    }
}