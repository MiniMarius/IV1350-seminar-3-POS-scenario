package integration;
import java.util.ArrayList;
import model.Item;
import model.SaleInformation;

/**
 * Class representing a external inventory system with items stored in an Arraylist of items objects.
 */
public class ExternalInventorySystem {
    private ArrayList<Item> itemsInStock = new ArrayList<>();

    /**
     * adding demo items to the Arraylist of items during the creation of EAS for use in the sample execution
     */
    public ExternalInventorySystem() {
        itemsInStock.add( new Item("Kebab", "A bag of kebab-meat, 400 g", 135.0, 10.0, 8));
        itemsInStock.add( new Item("Nuggets extra thick", "A bag of chicken-nuggets, 20 pieces", 50.0, 25.0, 3));
        itemsInStock.add( new Item("Sour Apple candy", "A bag of candy, green and yellow", 60.0, 25.0, 5));
        itemsInStock.add( new Item("ice-cream superIcy", "A big tub of ice cream", 22.0, 25.0, 6));
    }
    /**
     * Checks inventory for item with matching
     * @param itemId and
     * @return item The found item in stock
     */
    public Item checkInventory(Integer itemId) {
        for (Item item : itemsInStock) {
            if (item.getStoreKeepingUnitNumber().equals(itemId)){
                return item;
            }
        }
        return null;
    }

    /**
     * Compares sold items with items in stock and removing sold items from stock i.e keeping inventory up to date
     * @param saleInformation instance of SaleInformation which holds an ArrayList of items to be compared with stock
     */
    public void updateInventory(SaleInformation saleInformation) {
        itemsInStock.removeAll(saleInformation.getBoughtItems());
        }

    /**
     *
     * @return returns whole Arraylist of items in stock
     */
    public ArrayList<Item> getAllItemsInStock() {
        return itemsInStock;
    }
}
