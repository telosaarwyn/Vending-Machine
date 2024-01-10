package models;

/**
 * The Transaction class constructs the transactions made to the vending machine.
 * It includes the getters for the transaction summary of the existing vending machine.
 * 
 * @author Lim, Theoni Anne
 *         Telosa, Arwyn Gabrielle
 * @version 1.0
 * @since 06-02-23 
 */
public class Transaction
{
    private String itemBought;                /** attributes of the Transaction class */
    private int price;
    
    /**
     * The Transaction constructor method initializes the attributes for the Transaction, such as the itemBought and price.
     * @param itemBought item purchased by the user
     * @param price how much the item costs
     */
    public Transaction(String itemBought, int price)
    {
        // initializes the itemBought and its price
        this.itemBought = itemBought;
        this.price = price;
    }

    /**
     * The getItemBought method is the getter that gets the item that the user bought.
     * @return item bought by the user
     */
    public String getItemBought()
    {
        return itemBought;
    }
    
    /**
     * The getPrice method is the getter that gets the price of the item.
     * @return price of item
     */
    public int getPrice()
    {
        return price;
    }
}
