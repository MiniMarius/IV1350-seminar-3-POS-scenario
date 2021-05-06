package integration;

import model.Receipt;

/**
 * simulating a external printer system
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
