package view;
import controller.*;
import model.Item;

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
        System.out.println(controller.enterItem(3, 1));
        System.out.println(controller.enterItem(11, 1));
        System.out.println(controller.enterItem(6, 1));

        System.out.println("Sale ended" + "\n" + "Total with taxes: " + controller.endSale());

        System.out.println("Discounted Total with taxes: " + controller.discountRequest(8));
        System.out.println("Handing over payment");
        Double change = controller.makePayment(500.00);
        System.out.println("Change to customer: " + change);
    }
}
