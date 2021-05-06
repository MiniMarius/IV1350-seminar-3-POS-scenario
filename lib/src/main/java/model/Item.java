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
        this.vat = (vat / 100) + 1;
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
     * @param name the name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param description the description String to be set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @param price the price to be set for the item
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     *
     * @param vat the items vat to be set
     */
    public void setVat(Double vat) {
        this.vat = (vat/100) + 1;
    }

    /**
     *
     * @param storeKeepingUnitNumber set an items store keeping number
     */
    public void setStoreKeepingUnitNumber(Integer storeKeepingUnitNumber) {
        this.storeKeepingUnitNumber = storeKeepingUnitNumber;
    }

    /**
     *
     * @return a string representation of the item
     */



    public String toString() {
        return "Item " +
                "name: " + name + '\'' +
                ", description: " + description + '\'' +
                ", price: " + price +
                ", vat: " + vat +
                ", storeKeepingUnitNumber: " + storeKeepingUnitNumber;
    }
}
