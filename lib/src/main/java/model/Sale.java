package model;

import integration.Discount;

import java.util.ArrayList;

public class Sale {
    private ArrayList<Item> scannedItems = new ArrayList<>();
    private SaleInformation saleInformation;
    private Double total;

    public Sale () {
        SaleInformation saleInformation = new SaleInformation();
    }

    public void UpdateRunningTotal(Item item, Integer amountOfitems) {
        total += item.getPrice() * amountOfitems;
    }

    public void addItem(Item item, Integer amountOfItems) {
        for (int i = 0; i < amountOfItems; i++) {
            scannedItems.add(item);
        }
    }
    public Double getTotal() {
        return total;
    }

    public String toString() {
        return "Sale: " +
                "scannedItems: " + scannedItems +
                ", total: " + total;
    }
    public void applyDiscount(Discount discount) {
        total -= discount.GetDiscount();
    }
    public SaleInformation endSale() {
        saleInformation.confirmSale(scannedItems);
        return saleInformation;
    }
}
