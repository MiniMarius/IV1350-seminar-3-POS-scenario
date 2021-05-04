package model;

/**
 * represents an Item existing in a store
 */
public class Item {
    private String name;
    private String description;
    private Double price;
    private Double vat;
    private Integer storeKeepingUnitNumber;

    public Item() {
    }

    /**
     *
     * @param name The name of the item
     * @param description A description of the item to be created
     * @param price How much the item costs
     * @param vat   The percentage of vat of item to be created
     * @param storeKeepingUnitNumber Unique identifier used for identifying item
     */
    public Item(String name, String description, Double price, Double vat, Integer storeKeepingUnitNumber) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.vat = vat;
        this.storeKeepingUnitNumber = storeKeepingUnitNumber;
    }

    /**
     *
     * @return storeKeepingUnitNumber
     */
    public Integer getStoreKeepingUnitNumber() {
        return storeKeepingUnitNumber;
    }

    /**
     *
     * @return vat
     */
    public Double getVat() {
        return vat;
    }

    /**
     *
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     *
     * @return the description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return name of item
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return a string representation of the item
     */
    public String toString() {
        return "Item:" +
                "name: " + name + '\'' +
                ", description: " + description + '\'' +
                ", price: " + price +
                ", vat: " + vat +
                ", storeKeepingUnitNumber: " + storeKeepingUnitNumber;
    }
}
