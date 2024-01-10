package items;

/**
 * The Sundae class represents the sundae to be serves as a side with the burger.
 * 
 * @author LIM, Theoni Anne
 *         TELOSA, Arwyn Gabrielle
 * @version 1.0
 * @since 07-22-2023
 */
public class Sundae extends Item
{
    private static int price = 270;
    /**
     * The Sundae constructor sets the attributes for the "Sundae" item.
     * It calls the constructor of the superclass (Item) to set common attributes.
     */
    public Sundae()
    {
        super(270, "Twirling up the sundaes everyday...", true);
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
