package model;
import integration.Discount;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

/**
 * stores saleInformation to be sent to accounting system and for receipts
 */
public class SaleInformation {
    private ArrayList<Item> boughtItems = new ArrayList<>();
    private String timeOfPurchase;
    private Payment payment;
    private Discount appliedDiscount;

    public SaleInformation() {
    }

    /**
     *
     * @param payment the payment amount used for paying for items
     * @param appliedDiscount saves the discount calculated for a sale
     */
    public SaleInformation(Payment payment, Discount appliedDiscount) {
        this.payment = payment;
        this.appliedDiscount = appliedDiscount;
    }

    /**
     * saves confirmed information from sale, including current time
     * @param confirmedItems the list of items scanned in sale being stored
     */
    public void confirmSale(ArrayList<Item> confirmedItems) {
        boughtItems = confirmedItems;
        timeOfPurchase = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

    }

    @Override
    public String toString() {
        return "timeOfPurchase: " + timeOfPurchase + '\'' +
                ", payment: " + payment +
                ", appliedDiscount" + appliedDiscount +
                '}';
    }
}
