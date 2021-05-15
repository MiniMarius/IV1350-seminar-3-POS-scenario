package model;

import integration.Discount;

import java.util.ArrayList;

/**
 * represents a ongoing sale in the POS scenario
 */
public class Sale {
    private ArrayList<Item> scannedItems = new ArrayList<>();
    private Double runningTotalWithTax;
    private Discount discount;

    public Sale () {
        runningTotalWithTax = 0.0;
    }

    /**
     * Takes a scanned item's price, vat and amount to calculate running total
     * @param scannedItem an instance of Item to take the price of
     */
    public void UpdateRunningTotal(Item scannedItem) {
        runningTotalWithTax += scannedItem.getPrice() * scannedItem.getAmount() * scannedItem.getVat();
    }

    /**
     * Adds the scanned item to the active sale. If item already scanned, increase quantity of item sold by
     * amount scanned
     * @param item instance of Item to be added to the Arraylist of items scanned
     * @param amountOfItem the amount of said item to add to the ArrayList scannedItems
     */
    public void addItem(Item item, Integer amountOfItem) {
        for (Item scannedItem : scannedItems) {
            if (scannedItem.getStoreKeepingUnitNumber().equals(item.getStoreKeepingUnitNumber())){
                scannedItem.increaseAmount(amountOfItem);
            }
            else {
                item.setAmount(amountOfItem);
                scannedItems.add(item);
            }
        }
    }


    /**
     *
     * @param scannedItems the ArrayList of items to be set as the scanned items
     */
    public void setScannedItems(ArrayList<Item> scannedItems) {
        this.scannedItems = scannedItems;
    }

    /**
     * Returns the sale's total
     * @return the runningTotalWithTax OR runningTotalWithTax - discounts depending on if discount exists
     */
    public Double getTotal() {
        /*
        if (discount != null) {
            return runningTotalWithTax - discount.getDiscount();
        }
         */
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
     * @param discount set a discount object as attribute
     */
    public void setDiscount(Discount discount) {
        this.discount = discount;
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
        this.discount = discount;
    }

    /**
     * Creates a instance of SaleInformation with the necessary info from the Sale
     * @param payment instance of Payment which is used for creation of SaleInformation instance
     * @return the newly created SaleInformation instance which contains the items scanned, payment and discount for the sale
     */
    public SaleInformation createSaleInfo(Payment payment) {
        SaleInformation saleInformation = new SaleInformation(payment, discount);
        saleInformation.confirmSale(scannedItems);
        return saleInformation;
    }


}
