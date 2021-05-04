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
        controller.enterItem(3, 5);
        controller.enterItem(8, 2);
        controller.enterItem(6, 1);

        controller.endSale();

        controller.discountRequest(8);
        Double change = controller.makePayment(500.00);
        System.out.println(change);
    }
}
