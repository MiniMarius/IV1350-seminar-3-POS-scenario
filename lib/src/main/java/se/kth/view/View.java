package se.kth.view;
import se.kth.controller.*;
import se.kth.model.Sale;
import se.kth.controller.Controller;

/**
 * View will simulate user input
 */
public class View {
    private Controller controller;

    /**
     * Creates a view object, representing a view of mvc-architecture
     * @param controller makes all of the calls
     */
    public View(Controller controller){
        this.controller = controller;
    }


    /**
     * Sample execution of application, simulating user input
     */
    public void sampleExecution(){
        controller.makeNewSale();
        System.out.println("New sale started");
        System.out.println("Scanning items");

        showSaleInfo(controller.enterItem(3, 1));
        showSaleInfo(controller.enterItem(11, 1));
        showSaleInfo(controller.enterItem(3, 5));
        showSaleInfo(controller.enterItem(6, 1));

        System.out.println("Sale ended" + "\n" + "Total with taxes: " + controller.endSale());
        System.out.println("Discounted Total with taxes: " + controller.discountRequest(8));
        System.out.println("Handing over payment");
        Double change = controller.makePayment(500.00);
        System.out.println("Change to customer: " + change);
    }

    private void showSaleInfo(Sale sale) {
        if (sale == null) {
            System.out.println("The identifier is invalid" + "\n");
        }
        else
            System.out.println(sale);
    }
}
