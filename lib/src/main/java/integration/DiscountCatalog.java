package integration;

import model.Item;
import model.Sale;

import java.util.ArrayList;

/**
 * Stores the requirements needed to obtain a discount, including discounted item-objects
 */
public class DiscountCatalog {
    private Discount discount;
    private Integer customerId;
    private ArrayList<Item> discountedItems = new ArrayList<>();

    /**
     * Creates a demo-list of discount rules during creation of DiscountCatalog instance
     */
    public DiscountCatalog() {
        discountedItems.add( new Item("Kebab", "A bag of kebab-meat, 400 g", 135.0, 10.0, 8));
        discountedItems.add( new Item("Nuggets extra thick", "A bag of chicken-nuggets, 20 pieces", 50.0, 25.0, 3));
        discountedItems.add( new Item("Sour Apple candy", "A bag of candy, green and yellow", 60.0, 25.0, 5));
        discountedItems.add( new Item("ice-cream superIcy", "A big tub of ice cream", 22.0, 25.0, 6));
        customerId = 8;

    }

    /**
     *
     * @param idNumber The id to be compared to the stored customerId eligible for discount
     * @return Discount object with certain discount stored inside after calculation
     */
    public Discount calculateDiscount(Integer idNumber, Sale sale) {
        discount = new Discount();
        if (idNumber.equals(customerId) && sale.getTotal() >= 50.0) {
            discount.SetDiscount(10.0);
        }
        else if (idNumber.equals(customerId) && sale.getTotal() >= 100.0) {
            discount.SetDiscount(20.0);
        }
        return discount;
    }
}
