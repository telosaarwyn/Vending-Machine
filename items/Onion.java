package items;

/**
 * The Onion class represents the onion to be used in the burger.
 * 
 * @author LIM, Theoni Anne
 *         TELOSA, Arwyn Gabrielle
 * @version 1.0
 * @since 07-22-2023
 */
public class Onion extends Item
{
    private static int price = 50;
    /**
     * The Onion constructor sets the attributes for the "Onion" item.
     * It calls the constructor of the superclass (Item) to set common attributes.
     */
    public Onion()
    {
        super(120, "Caramelizing the onions...", true);
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
