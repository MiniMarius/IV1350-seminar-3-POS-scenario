package controller;

import integration.*;
import model.*;

/**
 * The application's controller. Responsible for all the calls to the model
 * Methods are expected to be called in a certain order
 */
public class Controller {
    private ExternalInventorySystem externalInventorySystem;
    private ExternalAccountingSystem externalAccountingSystem;
    private Printer printer;
    private Register register;
    private DiscountCatalog discountCatalog;
    private Discount discount;
    private Sale sale;

    /**
     *
     * @param printer is used to get access to printer used in POS
     * @param discountCatalog Is used to access discount catalog for discount request
     * @param externalAccountingSystem Is used to access accounting system to save sale information into
     * @param externalInventorySystem Is used to access items currently in stock in inventory
     */
    public Controller(Printer printer, DiscountCatalog discountCatalog, ExternalAccountingSystem externalAccountingSystem, ExternalInventorySystem externalInventorySystem) {
        this.printer = printer;
        this.discountCatalog = discountCatalog;
        this.externalAccountingSystem = externalAccountingSystem;
        this.externalInventorySystem = externalInventorySystem;
        register = new Register();
    }

    /**
     * If item identifier entered is matched with item in inventory system we will add it to the sale
     * @param itemId the id of the item we are looking for in inventory system
     * @param amountOfItems The amount of said item we are looking for
     */
    public void enterItem(Integer itemId, int amountOfItems){
        Item searchedItem = externalInventorySystem.checkInventory(itemId, amountOfItems);
        sale.addItem(searchedItem, amountOfItems);
        sale.UpdateRunningTotal(searchedItem, amountOfItems);
        System.out.println(sale);
    }

    /**
     * Applies discount requested by customer
     * @param customerId the id to be checked for discount level.
     */
    public void discountRequest(Integer customerId){
        discount = discountCatalog.calculateDiscount(customerId);
        sale.applyDiscount(discount);
    }

    /**
     * ends the sale, confirming items scanned in sale
     */
    public void endSale(){
        SaleInformation saleinformation = sale.endSale();
        externalAccountingSystem.logSale(saleinformation);
        Receipt receipt = new Receipt(saleinformation);
        printer.printReceipt(receipt);
    }

    /**
     *
     * @param amount the amount used to pay with
     * @return the calculated amount of change that we are due
     */
    public Double makePayment(Double amount){
        Payment payment = new Payment(amount);
        return register.calculateChange(payment, sale);
    }

    /**
     * creates a new sale object
     */
    public void makeNewSale(){
        sale = new Sale();
    }

}
