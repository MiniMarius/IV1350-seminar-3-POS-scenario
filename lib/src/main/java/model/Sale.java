package model;

import integration.Discount;

import java.util.ArrayList;

public class Sale {
    private ArrayList<Item> scannedItems = new ArrayList<>();
    private Double total;

    public Sale () {
        total = 0.0;
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
        SaleInformation saleInformation = new SaleInformation();
        saleInformation.confirmSale(scannedItems);
        return saleInformation;
    }
}
