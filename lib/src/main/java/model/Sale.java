package model;

import integration.Discount;

import java.util.ArrayList;

public class Sale {
    private ArrayList<Item> scannedItems = new ArrayList<>();
    private Double runningTotalWithTax;
    private Discount Discount;

    public Sale () {
        runningTotalWithTax = 0.0;
    }

    public void UpdateRunningTotal(Item item, Integer amountOfitems) {
        runningTotalWithTax += item.getPrice() * amountOfitems * item.getVat();
    }

    public void addItem(Item item, Integer amountOfItems) {
        for (int i = 0; i < amountOfItems; i++) {
            scannedItems.add(item);
        }
    }
    public Double getTotal() {
        if (Discount != null) {
            return runningTotalWithTax - Discount.GetDiscount();
        }
        return runningTotalWithTax;
    }
    public void setTotalWithTax(Double amount) {
        runningTotalWithTax = amount;
    }

    public String toString() {
        return "scannedItems: " + scannedItems +
                "\n" + "RunningTotal: " + runningTotalWithTax + "\n";
    }

    public void applyDiscount(Discount discount) {
        Discount = discount;
    }

    public SaleInformation confirmPaidSale(Payment payment) {
        SaleInformation saleInformation = new SaleInformation(payment, Discount);
        saleInformation.confirmSale(scannedItems);
        return saleInformation;
    }
}
