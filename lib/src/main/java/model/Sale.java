package model;

import integration.Discount;

import java.util.ArrayList;

/**
 * represents a ongoing sale in the POS scenario
 */
public class Sale {
    private ArrayList<Item> scannedItems = new ArrayList<>();
    private Double runningTotalWithTax;
    private Discount Discount;

    public Sale () {
        runningTotalWithTax = 0.0;
    }

    /**
     *
     * @param item an instance of Item to take the price of
     * @param amountOfItems The amount of said item to increase the total with
     */
    public void UpdateRunningTotal(Item item, Integer amountOfItems) {
        runningTotalWithTax += item.getPrice() * amountOfItems * item.getVat();
    }

    /**
     *
     * @param item instance of Item to be added to the Arraylist of items scanned
     * @param amountOfItems the amount of said item to add to the ArrayList
     */
    public void addItem(Item item, Integer amountOfItems) {
        for (int i = 0; i < amountOfItems; i++) {
            scannedItems.add(item);
        }
    }

    /**
     * Returns the sale's total
     * @return the runningTotalWithTax OR runningTotalWithTax - discounts depending on if discount exists
     */
    public Double getTotal() {
        if (Discount != null) {
            return runningTotalWithTax - Discount.getDiscount();
        }
        return runningTotalWithTax;
    }

    /**
     *
     * @return returns an ArrayList of the scanned items
     */
    public ArrayList<Item> getScannedItems() {
        return scannedItems;
    }

    /**
     *
     * @param amount the amount to manually set the total of the sale to
     */
    public void setTotalWithTax(Double amount) {
        runningTotalWithTax = amount;
    }

    /**
     *
     * @return a string representation of the items scanned and running total
     */
    public String toString() {
        return "scannedItems: " + scannedItems +
                "\n" + "RunningTotal: " + runningTotalWithTax + "\n";
    }

    /**
     *
     * @param discount instance of Discount class to be applied as attribute to sale
     */
    public void applyDiscount(Discount discount) {
        Discount = discount;
    }

    /**
     * Creates a instance of SaleInformation with the necessary info from the Sale
     * @param payment instance of Payment which is used for creation of SaleInformation instance
     * @return the newly created SaleInformation instance which contains the items scanned, payment and discount for the sale
     */
    public SaleInformation createSaleInfo(Payment payment) {
        SaleInformation saleInformation = new SaleInformation(payment, Discount);
        saleInformation.confirmSale(scannedItems);
        return saleInformation;
    }
}
