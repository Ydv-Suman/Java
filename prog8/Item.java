/**
 * The Item class represents an item in the store's inventory.
 * It stores details such as the item ID, cost, selling price, and quantity.
 * Provides methods to retrieve and update these properties.
 */
public class Item{
    private String itemId;
    private double itemCost;
    private double sellingPrice;
    private int itemQuantity;

    /**
     * Constructs a new Item with the specified item ID, cost, and selling price.
     * The item quantity is initially set to zero.
     *
     * @param itemId The unique identifier for the item.
     * @param itemCost The cost price of the item.
     * @param sellingPrice The selling price of the item.
     * @param itemQuantity sets to zero.
     */

    public Item(String itemId, double itemCost, double sellingPrice){
        this.itemId = itemId;
        this.itemCost = itemCost;
        this.sellingPrice = sellingPrice;
        this.itemQuantity = 0;
    }

    /**
     * getId method
     * @return The item ID.
     */
    public String getId(){
        return this.itemId;
    }

    /**
     * getCost method
     * @return The item cost.
     */
    public double getCost(){
        return this.itemCost;
    }

    /**
     * getSellingPrice method
     * @return The selling price.
     */
    public double getSellingPrice(){
        return this.sellingPrice;
    }

    /**
     * getQuantity method
     * @return The item quantity.
     */
    public int getQuantity(){
        return this.itemQuantity;
    }

    /**
     * void method that updates the quantity of the item in inventory.
     * adjust the quantity of item
     * @param quantity The quantity to adjust.
     */
    public void setQunatity(int quantity){
        this.itemQuantity += quantity;
    }

    /**
     * Returns a string representation of the item, including the item ID, cost, and quantity.
     * @return A string representation of the item.
     */
    public String toString(){
        return String.format("%s%.2f%d",getId(), getCost(), getQuantity()) ;
    }
}