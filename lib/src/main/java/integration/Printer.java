package integration;

import model.Receipt;

/**
 * used for printing receipts
 */
public class Printer {
    public Printer() {
    }

    /**
     *
     * @param receipt the receipt to be printed
     */
    public void printReceipt(Receipt receipt) {
        System.out.println(receipt);
    }
}
