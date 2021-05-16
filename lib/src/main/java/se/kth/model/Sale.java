package se.kth.model;

import se.kth.integration.Discount;

import java.util.ArrayList;

/**
 * represents a ongoing sale in the POS scenario
 */
public class Sale {
    private ArrayList<Item> scannedItems = new ArrayList<>();
    private Item lastScannedItem;
    private Double runningTotalWithTax;
    private Discount discount;

    public Sale () {
        runningTotalWithTax = 0.0;
    }

    /**
     * Takes all scanned item's price, vat and amount to calculate running total
     */
    public void updateRunningTotal() {
        runningTotalWithTax = 0.0;
        for (Item scannedItem : scannedItems) {
            runningTotalWithTax += scannedItem.getPrice() * scannedItem.getAmount() * scannedItem.getVat();
        }
    }

    /**
     * Adds the scanned item to the active sale. If item already scanned, increase quantity of item sold by
     * amount scanned
     * @param item instance of Item to be added to the Arraylist of items scanned
     */
    public void addItem(Item item) {
        lastScannedItem = item;
        for (Item scannedItem : scannedItems) {
            if (scannedItem.getStoreKeepingUnitNumber().equals(item.getStoreKeepingUnitNumber())) {
                scannedItem.increaseAmount(item.getAmount());
                return;
            }
        }
        scannedItems.add(item);
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
        if (discount != null) {
            return runningTotalWithTax - discount.getDiscount();
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
     * @param discount set a discount object as attribute
     */
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    /**
     *
     * @return a string representation of the item scanned and running total
     */@Override
    public String toString() {
         return "scanned Item: " + lastScannedItem.getDescription() + "," + " Price: " + lastScannedItem.getPrice() +
                "\n" + "RunningTotal with tax: " + runningTotalWithTax + "\n";
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
