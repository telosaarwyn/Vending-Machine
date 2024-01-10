package items;


/**
 * The Drink class represents the drink to be serves as a side with the burger.
 * 
 * @author LIM, Theoni Anne
 *         TELOSA, Arwyn Gabrielle
 * @version 1.0
 * @since 07-22-2023
 */
public class Coke extends Item
{
    private static int price = 70;
    
     /**
     * The Coke constructor sets the attributes for the "Coke" item.
     * It calls the constructor of the superclass (Item) to set common attributes.
     */
    public Coke() {
        super(140, "Unwinding refreshness in a cup...", true);
    }
    
     @Override
    /**
     * The getPrice method retrieves the price of the item.
     */
    public int getPrice() {
        return this.price;
    }
    
    @Override
    /**
     * The setPrice method sets the new price of this item.
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
