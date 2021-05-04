package integration;

import model.Item;

import java.util.ArrayList;

/**
 * Stores the requirements needed to obtain a discount, including discounted item-objects
 */
public class DiscountCatalog {
    private Discount discount;
    private Integer numOfItems;
    private Double totalCost;
    private Integer levelOfDiscount;
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
    public Discount calculateDiscount(Integer idNumber) {
        discount = new Discount();
        if (idNumber.equals(customerId)) {
            discount.SetDiscount(50.0);
        }
        return discount;

    }
}
