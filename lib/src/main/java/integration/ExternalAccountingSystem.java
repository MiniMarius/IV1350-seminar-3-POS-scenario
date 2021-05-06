package integration;

import model.Sale;
import model.SaleInformation;

import java.util.ArrayList;

/**
 * class representing an accounting system, storing saleInformation in Arraylist of saleinformation objects
 */
public class ExternalAccountingSystem {
    private ArrayList<SaleInformation> loggedSales = new ArrayList<SaleInformation>();
    private Double revenue;


    public ExternalAccountingSystem() {
    }

    /**
     *
     * @param saleInformation - the instance of saleInformation to be added to the accounting system
     */
    public void logSale(SaleInformation saleInformation) {
        loggedSales.add(saleInformation);
    }

    /**
     *
     * @return Arraylist of all stored saleInformation objects
     */
    public ArrayList<SaleInformation> getLoggedSales() {
        return loggedSales;
    }

    public void calculateRevenue() {

    }
}
