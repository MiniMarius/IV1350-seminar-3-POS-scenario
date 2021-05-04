package model;

/**
 * stores the money to be used for change for payments
 */
public class Register {
    private Double change;
    public Register() {
        setChange(250.00);
    }

    /**
     * Calculates change of change in register after receiving payment for sale and returns the amount of change to give to customer
     * @param payment the amount used to pay for the sale
     * @param sale The sale instance used for calculating change of change
     */
    public Double calculateChange(Payment payment, Sale sale) {
        change += (payment.getAmount() - sale.getTotal());
        Double changeToGiveBack =
    }

    /**
     *
     * @param amount the amount to be added to the register
     */
    public void addChange(Double amount) {
        change += amount;
    }

    /**
     *
     * @param amount the amount to initially set the register to
     */
    public void setChange(Double amount) {
        change = amount;
    }

    /**
     *
     * @return the amount of change inside register
     */
    public Double getChange() {
        return change;
    }

}
