package items;


/**
 * The Cheese class represents the cheese to be used in the burger.
 * 
 * @author LIM, Theoni Anne
 *         TELOSA, Arwyn Gabrielle
 * @version 1.0
 * @since 07-22-2023
 */
public class Cheese extends Item
{
    private static int price = 12;

    /**
     * The Cheese constructor sets the attributes for the "Cheese" item.
     * It calls the constructor of the superclass (Item) to set common attributes.
     */
    public Cheese() {
        super(80, "Grating, melting, savoring the cheese...", true);
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
