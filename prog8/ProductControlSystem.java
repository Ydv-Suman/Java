/**
   Date:12/02/2024
   Course: CSCI2073-44355-fall 2024
   Description: This program ProductControlSystem is to manage the inventory for a specialty
                store. This class preocess transaction data from a file, handling actions like
                add, delete, buy, sell, and report. It uses Item class for accessing the different
                data from file. At the end, it produces report containing all the details for the 
                store.

        Oh my honor, I have neither given nor received unauthorized help while
   completing this assignment.
   Name: Suman Yadav
   CWID: 30158478
 */
import java.io.*;
import java.util.*;
/**
 * ProductControlSystem class manages an inventory of items
 * processes transactions thorugh new, delete, buy, sell, and report
 * calculates total profit and total cost for the inventory
 */
public class ProductControlSystem{
    /**
     * A Map representing the inventory of items, ItemId as key
     */
    private Map<String, Item> inventory;
    /**
     * A StringBuilder used for displaying the output message  as transactions are processed
     * It helps build the result in the processTransactions method
     */
    private StringBuilder strBuilder;
    /**
     * The total profit generated from selling items in the inventory. This value is updated as items are sold. 
     */
    private double totalProfit;
    /**
     * The total cost of acquiring items into the inventory. This value is updated as items are bought.
     */
    private double totalCost;
    
    /**
     * Constructs a new ProductControlSystem instance
     * Initializes the inventory as HashMap, and strBuilder as string builder
     * sets total profit and total cost to zero
     */

    public ProductControlSystem(){
        inventory = new HashMap<String, Item>();
        this.strBuilder = new StringBuilder();
        this.totalProfit = 0.0;  
        this.totalCost = 0.0; 
    }

    /**
     * Processes processTransactions from specified file
     * @param dataFile The name of file containing the type of transaction and details
     * Each line in the file have transaction type
     * Contains * will denotes the end of inputs
     * Each transaction type will shapes the format of each line
     *  - new ItemId item-costprice item-sellingprice
     *  - delete itemId
     *  - buy itemId quantity
     *  - sell itemId qunatity
     *  - report
     * Uses switch to process the transaction of file.
     * @return a string displaying the result of processing all transactions in the specified file
     * @throws IOException if error occured during handling the file.
     */

    public String processTransactions(String dataFile){
        try {
            Scanner scan = new Scanner(new File(dataFile));
            while(scan.hasNextLine()){
                String eachLine = scan.nextLine();
                if(eachLine.equals("*")){
                    break;
                }
                Scanner in = new Scanner(eachLine);
                String action =in.next();
                switch(action) {
                    // handles "new" transaction Type
                    case "new":
                        add(in);
                    break;

                    // handles "delete" transaction Type
                    case "delete":
                        delete(in);
                    break;
                    
                    // handles "buy" transaction Type
                    case "buy":
                        buy(in);
                    break;

                    // handles "sell" transaction Type
                    case "sell":
                        sell(in);
                    break;

                    // handles "report" transaction Type
                    case "report":
                        report(in);
                    break;
                }
            }
            
        }
        catch (Exception e) {
            e.getMessage();
        }
    return this.strBuilder.toString().trim();
    }
    
    /**
     * Handles the "new" transaction type.
     * Adds a new item to the inventory if it does not already exist.
     * @param in The Scanner containing the transaction details (itemId, costPrice, sellingPrice).
     */
    public void add(Scanner in){
        String itemId = in.next();
        double costPrice = in.nextDouble();
        double sellingPrice = in.nextDouble();
        if (inventory.containsKey(itemId)){
            this.strBuilder.append("ERROR: ").append(itemId).append(" already in inventory\n");
        }
        else {
        Item item = new Item(itemId, costPrice, sellingPrice);
        inventory.put(itemId,item);
        this.strBuilder.append(itemId).append(" added to inventory\n");
        }
    }

    /**
     * Handles the "delete" transaction type.
     * Removes an item from the inventory if it exists, and updates the total cost and profit.
     * @param in The Scanner containing the transaction details (itemId).
     */
    public void delete(Scanner in){
        String itemId = in.next();
        if (!inventory.containsKey(itemId)){
            this.strBuilder.append("ERROR: ").append(itemId).append(" not in inventory\n");
        }
        else{
            Item deleteItem = inventory.remove(itemId);
            double loss = deleteItem.getQuantity() * deleteItem.getCost();
            this.totalCost -= loss;
            this.totalProfit -= loss;
            this.strBuilder.append(String.format( "%s removed from inventory for a total loss of $%.2f\n", itemId, loss));
        }
    }

    /**
     * Handles the "buy" transaction type.
     * Increases the quantity of an item in the inventory and updates the total cost.
     * @param in The Scanner containing the transaction details (itemId, quantity).
     */

    public void buy(Scanner in){
        String itemId = in.next();
        int quantity = in.nextInt();
        if(!inventory.containsKey(itemId)){
            strBuilder.append("ERROR: ").append(itemId).append(" not in inventory\n");
        }
        else {
            Item buyItem = inventory.get(itemId);
            buyItem.setQunatity(quantity);
            double buyCost = buyItem.getCost() * quantity;
            this.totalCost += buyCost;
            strBuilder.append(quantity).append(" units of ").append(itemId).append(String.format(" added to inventory at a total cost of $%.2f\n", buyCost));                                                    
        }
    }

    /**
     * Handles the "sell" transaction type.
     * Decreases the quantity of an item in the inventory, updates the total cost, and calculates profit.
     * @param in The Scanner containing the transaction details (itemId, quantity).
     */
    public void sell(Scanner in){
        String itemId = in.next();
        int quantity = in.nextInt();
        if (!inventory.containsKey(itemId)) {
            strBuilder.append("ERROR: ").append(itemId).append(" not in inventory\n");
        }
        else{
            Item sellItem = inventory.get(itemId);
            if (sellItem.getQuantity() < quantity){
                this.strBuilder.append("ERROR: ").append(quantity).append(" exceeds units of ").append(itemId).append(" in inventory\n");
            }
            else {
                double sellingPrice = quantity * sellItem.getSellingPrice();
                double costPrice = quantity * sellItem.getCost();
                double itemProfit = sellingPrice-costPrice;
                this.totalProfit += itemProfit;
                this.totalCost -= costPrice;
                sellItem.setQunatity(-quantity);              
                this.strBuilder.append(quantity).append(" units of ").append(itemId).append(String.format(" sold at a total price of $%.2f", sellingPrice)).append(String.format(" for a profit of $%.2f\n", itemProfit));
            }
        }
    }

    /**
     * Handles the "report" transaction type.
     * Appends a summary of the total cost and total profit to the output.
     * @param in The Scanner object (not used in this method).
     */

    public void report(Scanner in){
        this.strBuilder.append(String.format("Total cost: $%.2f", this.totalCost)).append(String.format(", Total profit: $%.2f\n", this.totalProfit));
    }
}