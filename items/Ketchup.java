package items;


/**
 * The Ketchup class represents the ketchup for the burger.
 * 
 * @author LIM, Theoni Anne
 *         TELOSA, Arwyn Gabrielle
 * @version 1.0
 * @since 07-22-2023
 */
public class Ketchup extends Item
{
    private static int price = 2;
    
    /**
     * The Ketchup constructor sets the attributes for the "Ketchup" item.
     * It calls the constructor of the superclass (Item) to set common attributes.
     */
    public Ketchup()
    {
        super(250, "Squeezing the ketchup bottle...", false);
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
